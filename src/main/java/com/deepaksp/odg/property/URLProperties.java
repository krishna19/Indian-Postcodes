package com.deepaksp.odg.property;

public enum URLProperties {
    PINCODE_WITH_CONTACT_DETAILS("0a076478-3fd3-4e2c-b2d2-581876f56d77"),
    PINCODE_WITH_CONTACT_DETAILS_AND_LOCATION("04cbe4b1-2f2b-4c39-a1d5-1c2e28bc0e32"),
    PINCODE("6176ee09-3d56-4a3b-8115-21841576b2f6");

    private String name;

    private URLProperties(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
