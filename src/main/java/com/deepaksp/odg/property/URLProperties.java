package com.deepaksp.odg.property;

public enum URLProperties {
    API_KEY("34e224bf7f9cb849abb75ef6ed22931e"),
    CONTACT_DETAILS("0a076478-3fd3-4e2c-b2d2-581876f56d77"),
    CONTACT_DETAILS_WITH_LOCATION("04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32");

    private String name;

    private URLProperties(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
