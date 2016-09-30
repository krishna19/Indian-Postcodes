package com.deepaksp.odg;

import java.io.IOException;
import java.util.HashMap;

import org.custommonkey.xmlunit.XMLAssert;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.xml.sax.SAXException;

import com.deepaksp.odg.constants.Keys;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PostcodeTest {

    @Test
    public void withContactDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void limitWithContactDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&limit=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).limit(10).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void offsetWithContactDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&offset=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).offset(10).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void sortWithContactDetailsAsJsonTest() throws UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING).asJson(),
                JSONCompareMode.STRICT);
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void withContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).asXML());
    }

    @Test
    public void limitWithContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&limit=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).limit(10).asXML());
    }

    @Test
    public void offsetWithContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&offset=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).offset(10).asXML());

    }

    @Test
    public void sortWithContactDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Postcode.withContactDetails(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING).asXML());
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Postcode.withContactDetails(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING).asXML());
    }

    @Test
    public void filtersWithContactDetailsAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77")
                .queryString("api-key", Keys.API_KEY).queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(),
                Postcode.withContactDetails(Keys.API_KEY.toString()).filters(new HashMap() {

                    {
                        put(Filter.PINCODE, 560073);
                    }
                }).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void fieldsWithContactDetailsAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=0a076478-3fd3-4e2c-b2d2-581876f56d77")
                .queryString("api-key", Keys.API_KEY).queryString("fields", "pincode").queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(), Postcode.withContactDetails(Keys.API_KEY.toString())
                        .fields(new Fields[] { Fields.PINCODE }).filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 560073);
                            }
                        }).asJson(),
                JSONCompareMode.LENIENT);
    }
}
