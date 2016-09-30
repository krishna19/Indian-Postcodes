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

public class PincodeContactLatitudeLongitudeTest {

    @Test
    public void withContactLatitudeLongitudeAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void limitWithContactLatitudeLongitudeAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&limit=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).limit(10).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void offsetWithContactLatitudeLongitudeAsJsonTest() throws JSONException, UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&offset=10")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).offset(10).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void sortWithContactLatitudeLongitudeAsJsonTest() throws UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING).asJson(),
                JSONCompareMode.STRICT);
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING).asJson(),
                JSONCompareMode.STRICT);
    }

    @Test
    public void withContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).asXML());
    }

    @Test
    public void limitWithContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&limit=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).limit(10).asXML());
    }

    @Test
    public void offsetWithContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&offset=10")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).offset(10).asXML());

    }

    @Test
    public void sortWithContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&sort[pincode]=asc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING).asXML());
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&sort[pincode]=desc")
                .queryString("api-key", Keys.API_KEY).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .sort(new Fields[] { Fields.PINCODE }, Sort.DESCENDING).asXML());
    }

    @Test
    public void filtersWithContactLatitudeLongitudeAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).filters(new HashMap() {

                    {
                        put(Filter.PINCODE, 560073);
                    }
                }).asJson(), JSONCompareMode.STRICT);
    }

    @Test
    public void filtersWithContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asString().getBody(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).filters(new HashMap() {

                    {
                        put(Filter.PINCODE, 560073);
                    }
                }).asXML());
    }

    @Test
    public void fieldsWithContactLatitudeLongitudeAsJsonTest() throws UnirestException, JSONException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).queryString("fields", "pincode").queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asJson().getBody().getObject(), Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .fields(new Fields[] { Fields.PINCODE }).filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 560073);
                            }
                        }).asJson(),
                JSONCompareMode.LENIENT);
    }

    @Test
    public void fieldsWithContactLatitudeLongitudeAsXMLTest() throws SAXException, IOException, UnirestException {
        XMLAssert.assertXMLEqual(Unirest
                .get("https://data.gov.in/api/datastore/resource.xml?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32")
                .queryString("api-key", Keys.API_KEY).queryString("fields", "pincode").queryString(new HashMap() {

                    {
                        put("filters[pincode]", 560073);
                    }
                }).asString().getBody(), Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString())
                        .fields(new Fields[] { Fields.PINCODE }).filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 560073);
                            }
                        }).asXML());
    }

    @Test
    public void testWithMoreParameters() throws UnirestException, IOException {
        JSONAssert.assertEquals(Unirest
                .get("https://data.gov.in/api/datastore/resource.json?resource_id=04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32&sort[pincode]=asc&filters[pincode]=110006&fields=pincode&limit=50&offset=0")
                .queryString("api-key", Keys.API_KEY).asJson().getBody().getObject(),
                Pincode.pincodeContactLatitudeLongitude(Keys.API_KEY.toString()).limit(50).offset(0)
                        .sort(new Fields[] { Fields.PINCODE }, Sort.ASCENDING).fields(new Fields[] { Fields.PINCODE })
                        .filters(new HashMap() {

                            {
                                put(Filter.PINCODE, 110006);
                            }
                        }).asJson(),
                JSONCompareMode.STRICT);
    }
}
