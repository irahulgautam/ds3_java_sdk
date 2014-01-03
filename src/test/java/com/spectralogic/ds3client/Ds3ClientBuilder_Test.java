package com.spectralogic.ds3client;


import com.spectralogic.ds3client.models.Credentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnit4.class)
public class Ds3ClientBuilder_Test {

    @Test
    public void createBasicClient() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.build();
        assertThat(client,is(notNullValue()));
    }

    @Test
    public void isNotSecure() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.withHttpSecure(false).build();
        assertThat(client.getConnectionDetails().isSecure(),is(false));
    }

    @Test
    public void defaultSecure() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.build();
        assertThat(client.getConnectionDetails().isSecure(),is(true));
    }

    @Test
    public void isSecure() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.withHttpSecure(true).build();
        assertThat(client.getConnectionDetails().isSecure(),is(true));
    }

    @Test
    public void defaultPort() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.build();
        assertThat(client.getConnectionDetails().getPort(), is(443));
    }

    @Test
    public void nonSecurePort() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.withHttpSecure(false).build();
        assertThat(client.getConnectionDetails().getPort(),is(80));
    }

    @Test
    public void nonStandardPort() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.withPort(8080).build();
        assertThat(client.getConnectionDetails().getPort(),is(8080));
    }

    @Test
    public void getClientEndpoint() throws Exception {
        final Ds3ClientBuilder builder = new Ds3ClientBuilder("myEndPoint", new Credentials("foo","bar"));
        final Ds3Client client = builder.withPort(8080).build();
        assertThat(client.getConnectionDetails().getEndpoint(),is("myEndPoint"));
    }

}