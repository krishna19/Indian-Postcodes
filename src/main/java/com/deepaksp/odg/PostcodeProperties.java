package com.deepaksp.odg;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.deepaksp.odg.property.URLProperties;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PostcodeProperties {

    private static Integer offset;

    private static Integer limit;

    private static String fields;

    private static String resource_id;

    private static String sortField;

    private static String sort;

    protected PostcodeProperties(URLProperties urlProperties) {
        PostcodeProperties.resource_id = urlProperties.toString();
    }

    /**
     * To offset number of rows
     * 
     * @param offset
     * @return
     */
    public PostcodeProperties offset(Integer offset) {
        PostcodeProperties.offset = offset;
        return this;
    }

    /**
     * maximum number of rows to return (default: 100)
     * 
     * @param limit
     * @return
     */
    public PostcodeProperties limit(Integer limit) {
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
        try {
            return Unirest.get(URLs.JSON.toString()).queryString("resource_id", resource_id)
                    .queryString("api-key", URLProperties.API_KEY.toString())
                    .queryString(StringUtils.trim(sortField) != null ? sortField : "sort[id]",
                            StringUtils.trim(sort) != null ? sort : Sort.ASCENDING.toString())
                    .queryString("limit", limit != null ? limit : 100).asJson().getBody().getObject();
        } finally {
            clear();
        }
    }

    public String asXML() throws UnirestException, IOException {
        try {
            return Unirest.get(URLs.XML.toString()).queryString("resource_id", resource_id)
                    .queryString("api-key", URLProperties.API_KEY.toString())
                    .queryString(StringUtils.trim(sortField) != null ? sortField : "sort[id]",
                            StringUtils.trim(sort) != null ? sort : Sort.ASCENDING.toString())
                    .queryString("limit", limit != null ? limit : 100).asString().getBody();
        } finally {
            clear();
        }
    }

    private void clear() {
        offset = null;
        limit = null;
        fields = null;
        resource_id = null;
        sortField = null;
        sort = null;
    }
}
