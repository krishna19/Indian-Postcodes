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
    public void limitWithContactDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&limit=10")
                .asJson().getBody().getObject(), Postcode.withContactDetails().limit(10).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void sortWithContactDetailsAsJsonTest() throws UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&sort[pincode]=asc")
                .asJson().getBody().getObject(),
                Postcode.withContactDetails().sort(new SortFields[] { SortFields.PINCODE }, Sort.ASCENDING).asJson(),
                JSONCompareMode.STRICT);
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&sort[pincode]=desc")
                .asJson().getBody().getObject(),
                Postcode.withContactDetails().sort(new SortFields[] { SortFields.PINCODE }, Sort.DESCENDING).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void withContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e")
                .asString().getBody(), Postcode.withContactDetails().asXML());
    }

    @Test
    public void limitWithContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&limit=10")
                .asString().getBody(), Postcode.withContactDetails().limit(10).asXML());
    }

    @Test
    public void sortWithContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&sort[pincode]=asc")
                .asString().getBody(),
                Postcode.withContactDetails().sort(new SortFields[] { SortFields.PINCODE }, Sort.ASCENDING).asXML());
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&api-key=34e224bf7f9cb849abb75ef6ed22931e&sort[pincode]=desc")
                .asString().getBody(),
                Postcode.withContactDetails().sort(new SortFields[] { SortFields.PINCODE }, Sort.DESCENDING).asXML());
    }
}
