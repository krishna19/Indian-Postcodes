package com.deepaksp.odg;

/**
 * @author Deepak
 *
 */
public enum Sort {
    ASCENDING("asc"),
    DESCENDING("desc");

    private String name;

    private Sort(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
