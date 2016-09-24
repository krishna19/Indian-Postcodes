package com.deepaksp.odg;

/**
 * @author Deepak
 *
 */
public enum URLs {

    JSON("https://data.gov.in/api/datastore/resource.json"),
    XML("https://data.gov.in/api/datastore/resource.xml");

    private String name;

    private URLs(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
