/*
 * ******************************************************************************
 *   Copyright 2014-2015 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

// This code is auto-generated, do not modify
package com.spectralogic.ds3client.commands.spectrads3;

import com.spectralogic.ds3client.HttpVerb;
import com.spectralogic.ds3client.commands.AbstractRequest;
import java.util.UUID;
import com.spectralogic.ds3client.models.DataReplicationRuleType;
import com.google.common.net.UrlEscapers;

public class CreateDataReplicationRuleSpectraS3Request extends AbstractRequest {

    // Variables
    
    private final UUID dataPolicyId;

    private final UUID ds3TargetId;

    private final DataReplicationRuleType type;

    private String ds3TargetDataPolicy;

    // Constructor
    
    public CreateDataReplicationRuleSpectraS3Request(final UUID dataPolicyId, final UUID ds3TargetId, final DataReplicationRuleType type) {
        this.dataPolicyId = dataPolicyId;
        this.ds3TargetId = ds3TargetId;
        this.type = type;
                this.getQueryParams().put("data_policy_id", dataPolicyId.toString());
        this.getQueryParams().put("ds3_target_id", ds3TargetId.toString());
        this.getQueryParams().put("type", type.toString());
    }

    public CreateDataReplicationRuleSpectraS3Request withDs3TargetDataPolicy(final String ds3TargetDataPolicy) {
        this.ds3TargetDataPolicy = ds3TargetDataPolicy;
        this.updateQueryParam("ds3_target_data_policy", UrlEscapers.urlFragmentEscaper().escape(ds3TargetDataPolicy));
        return this;
    }


    @Override
    public HttpVerb getVerb() {
        return HttpVerb.POST;
    }

    @Override
    public String getPath() {
        return "/_rest_/data_replication_rule";
    }
    
    public UUID getDataPolicyId() {
        return this.dataPolicyId;
    }


    public UUID getDs3TargetId() {
        return this.ds3TargetId;
    }


    public DataReplicationRuleType getType() {
        return this.type;
    }


    public String getDs3TargetDataPolicy() {
        return this.ds3TargetDataPolicy;
    }

}