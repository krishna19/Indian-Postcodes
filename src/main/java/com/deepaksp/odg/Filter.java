package com.deepaksp.odg;

public enum Filter {

    OFFICE_NAME("filters[officename]"),
    PINCODE("filters[pincode]"),
    OFFICE_TYPE("filters[officeType]"),
    DELIVERY_STATUS("filters[Deliverystatus]"),
    DIVISION_NAME("filters[divisionname]"),
    REGION_NAME("filters[regionname]"),
    CIRCLE_NAME("filters[circlename]"),
    TALUK("filters[Taluk]"),
    DISTRICT_NAME("filters[Districtname]"),
    STATE_NAME("filters[statename]"),
    TELEPHONE("filters[Telephone]"),
    RELATED_SUB_OFFICE("filters[Related Suboffice]"),
    RELATED_HEAD_OFFICE("filters[Related Headoffice]"),
    LONGITUDE("filters[longitude]"),
    LATITUDE("filters[latitude]");

    private String name;

    private Filter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
