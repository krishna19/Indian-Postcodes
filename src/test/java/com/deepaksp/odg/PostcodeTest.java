package com.deepaksp.odg;

import java.io.IOException;

import org.custommonkey.xmlunit.XMLAssert;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.xml.sax.SAXException;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PostcodeTest {

    @Test
    public void withContactDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e")
                .asJson().getBody().getObject(), Postcode.withContactDetails().asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void withContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e")
                .asString().getBody(), Postcode.withContactDetails().asXML());
    }
}
