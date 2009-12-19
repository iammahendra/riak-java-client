package com.basho.riak.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRiakConfig {

    @Test public void chomps_ending_slash() {
        final String URL = "url";
        RiakConfig impl = new RiakConfig(URL + "/");
        assertEquals(URL, impl.getUrl());
        
        impl.setUrl(URL + "/");
        assertEquals(URL, impl.getUrl());
        
        impl = new RiakConfig("ip", "port", URL + "/");
        assertFalse(impl.getUrl().endsWith("/"));
    }
    
    @Test public void builds_correct_url_from_ip_port_and_prefix() {
        RiakConfig impl = new RiakConfig("ip", "port", "/prefix");
        assertEquals("http://ip:port/prefix", impl.getUrl());
    }
    
}
