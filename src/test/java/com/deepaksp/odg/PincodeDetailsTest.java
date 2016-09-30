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

public class PincodeDetailsTest {

    @Test
    public void withPincodeDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        System.out.println(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).getUrl());
        System.out.println(Pincode.pincodeDetails(Keys.API_KEY.toString()).asJson());
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void limitPincodeDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&limit=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).limit(10).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void offsetPincodeDetailsAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&offset=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).offset(10).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void sortPincodeDetailsAsJsonTest() throws UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING)
                        .asJson(),
                JSONCompareMode.STRICT);
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING)
                        .asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void withPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).asXML());
    }

    @Test
    public void limitPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&limit=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).limit(10).asXML());
    }

    @Test
    public void offsetPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&offset=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).offset(10).asXML());

    }

    @Test
    public void sortPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING)
                        .asXML());
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING)
                        .asXML());
    }

    @Test
    public void filtersPincodeDetailsAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(),
                Pincode.pincodeDetails(Keys.API_KEY.toString()).filters(new HashMap() {

                    {
                        put(Filter.PINCODE, 560073);
                    }
                }).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void filtersPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asString().getBody(), Pincode.pincodeDetails(Keys.API_KEY.toString()).filters(new HashMap() {

                    {
                        put(Filter.PINCODE, 560073);
                    }
                }).asXML());
    }

    @Test
    public void fieldsPincodeDetailsAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).queryString("fields", "pincode").queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(), Pincode.pincodeDetails(Keys.API_KEY.toString())
                        .fields(new Fields[] { Fields.PINCODE }).filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 560073);
                            }
                        }).asJson(),
                JSONCompareMode.LENIENT);
    }

    @Test
    public void fieldsPincodeDetailsAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=6176ee09-3d56-4a3b-8115-21841576b2f6")
                .queryString("api-key", Keys.API_KEY).queryString("fields", "pincode").queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asString().getBody(), Pincode.pincodeDetails(Keys.API_KEY.toString())
                        .fields(new Fields[] { Fields.PINCODE }).filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 560073);
                            }
                        }).asXML());
    }
}
