package com.deepaksp.odg;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.deepaksp.odg.property.Property;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PostcodeProperties {

    private static int offset;

    private static int limit = 100;

    private static String fields;

    private static String resource_id;

    private static String sortField;

    private static String sort;

    protected PostcodeProperties(String resource_id) {
        PostcodeProperties.resource_id = resource_id;
    }

    /**
     * To offset number of rows
     * 
     * @param offset
     * @return
     */
    public PostcodeProperties offset(int offset) {
        PostcodeProperties.offset = offset;
        return this;
    }

    /**
     * maximum number of rows to return (default: 100)
     * 
     * @param limit
     * @return
     */
    public PostcodeProperties limit(int limit) {
        PostcodeProperties.limit = limit;
        return this;
    }

    /**
     * fields to return (default: all fields in original order)
     * 
     * @param fields
     * @return
     */
    public PostcodeProperties fields(String[] fields) {
        PostcodeProperties.fields = StringUtils.join(fields, ",");
        return this;
    }

    public PostcodeProperties sort(SortFields[] sortField, Sort sort) {
        PostcodeProperties.sortField = "sort[".concat(StringUtils.join(SortFields.toStringArray(sortField), ","))
                .concat("]");
        PostcodeProperties.sort = sort.toString();
        return this;
    }

    public JSONObject asJson() throws UnirestException, IOException {
        return Unirest.get(URLs.JSON.toString()).queryString("resource_id", Property.get(resource_id))
                .queryString("api-key", Property.get("api-key"))
                .queryString(StringUtils.trim(sortField) != null ? sortField : "sort[id]",
                        StringUtils.trim(sort) != null ? sort : Sort.ASCENDING.toString())
                .asJson().getBody().getObject();
    }

    public String asXML() throws UnirestException, IOException {
        return Unirest.get(URLs.XML.toString()).queryString("resource_id", Property.get(resource_id))
                .queryString("api-key", Property.get("api-key"))
                .queryString(StringUtils.trim(sortField) != null ? sortField : "sort[id]",
                        StringUtils.trim(sort) != null ? sort : Sort.ASCENDING.toString())
                .asString().getBody();
    }
}
