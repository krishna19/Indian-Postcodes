package com.deepaksp.odg.constants;

public enum Keys {
    API_KEY("34e224bf7f9cb849abb75ef6ed22931e");

    private String name;

    private Keys(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
