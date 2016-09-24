package com.deepaksp.odg.property;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class PropertyTest {

    @Test
    public void testGet() throws IOException {
        assertEquals("34e224bf7f9cb849abb75ef6ed22931e", Property.get("api-key"));
        assertEquals("0a076478-3fd3-4e2c-b2d2-581876f56d77", Property.get("contact_details_resource_id"));
        assertEquals("04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32", Property.get("resource_id2"));
    }
}
