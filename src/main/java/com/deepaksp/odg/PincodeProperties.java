package com.deepaksp.odg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.deepaksp.odg.property.URLProperties;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author Deepak
 *
 */
public class PincodeProperties {

    private static Integer offset;

    private static Integer limit;

    private static String fields;

    private static String resource_id;

    private static String sortField;

    private static String sort;

    private static HashMap<String, Object> filters;

    private static String api_key;

    protected PincodeProperties(URLProperties urlProperties, String api_key) {
        PincodeProperties.resource_id = urlProperties.toString();
        PincodeProperties.api_key = api_key;
    }

    /**
     * To offset number of rows
     * 
     * @param offset
     * @return
     */
    public PincodeProperties offset(Integer offset) {
        PincodeProperties.offset = offset;
        return this;
    }

    /**
     * matching conditions to select
     * 
     * @param filters
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PincodeProperties filters(HashMap<Filter, String> filters) {
        HashMap<String, Object> filter = new HashMap();
        for (Map.Entry<Filter, String> f : filters.entrySet()) {
            filter.put(f.getKey().toString(), f.getValue());
        }
        PincodeProperties.filters = filter;
        return this;
    }

    /**
     * maximum number of rows to return (default: 100)
     * 
     * @param limit
     * @return
     */
    public PincodeProperties limit(Integer limit) {
        PincodeProperties.limit = limit;
        return this;
    }

    /**
     * fields to return (default: all fields in original order)
     * 
     * @param fields
     * @return
     */
    public PincodeProperties fields(Fields[] fields) {
        PincodeProperties.fields = StringUtils.join(fields, ",");
        return this;
    }

    /**
     * Order by field in particular order
     * 
     * @param sortField
     * @param sort
     * @return
     */
    public PincodeProperties sort(Fields[] sortField, Sort sort) {
        PincodeProperties.sortField = "sort[".concat(StringUtils.join(Fields.toStringArray(sortField), ","))
                .concat("]");
        PincodeProperties.sort = sort.toString();
        return this;
    }

    public JSONObject asJson() throws UnirestException, IOException {
        try {
            return Unirest.get(URLs.JSON.toString()).queryString("resource_id", resource_id)
                    .queryString("api-key", api_key)
                    .queryString(StringUtils.trim(sortField) != null ? sortField : "sort[id]",
                            StringUtils.trim(sort) != null ? sort : Sort.ASCENDING.toString())
                    .queryString("limit", limit != null ? limit : 100)
                    .queryString("offset", offset != null ? offset : 0)
                    .queryString(fields != null ? "fields" : "", fields != null ? fields : "")
                    .queryString(filters != null ? filters : new HashMap<>()).asJson().getBody().getObject();
        } finally {
            clear();
        }
    }

    public String asXML() throws UnirestException, IOException {
        try {
            return Unirest.get(URLs.XML.toString()).queryString("resource_id", resource_id)
                    .queryString("api-key", api_key)
                    .queryString(StringUtils.trim(sortField) != null ? sortField : "",
                            StringUtils.trim(sort) != null ? sort : "")
                    .queryString("limit", limit != null ? limit : 100)
                    .queryString("offset", offset != null ? offset : 0)
                    .queryString(fields != null ? "fields" : "", fields != null ? fields : "")
                    .queryString(filters != null ? filters : new HashMap<>()).asString().getBody();
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
        filters = null;
    }
}
