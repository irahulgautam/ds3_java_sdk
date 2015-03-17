package com.spectralogic.ds3client.commands.notifications;

import java.util.UUID;

public class DeletePartitionFailureNotificationRequest extends AbstractDeleteNotificationRequest {
    public DeletePartitionFailureNotificationRequest(final UUID notificationId) {
        super(notificationId);
    }

    @Override
    public String getPath() {
        return "/_rest_/tape_partition_failure_notification_registration/" + this.getNotificationId().toString();
    }
}
