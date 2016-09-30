package com.deepaksp.odg;

/**
 * @author Deepak
 *
 */
public enum Fields {

    OFFICE_NAME("officename"),
    PINCODE("pincode"),
    OFFICE_TYPE("officeType"),
    DELIVERY_STATUS("Deliverystatus"),
    DIVISION_NAME("divisionname"),
    REGION_NAME("regionname"),
    CIRCLE_NAME("circlename"),
    TALUK("Taluk"),
    DISTRICT_NAME("Districtname"),
    STATE_NAME("statename"),
    TELEPHONE("Telephone"),
    RELATED_SUB_OFFICE("Related Suboffice"),
    RELATED_HEAD_OFFICE("Related Headoffice"),
    LONGITUDE("longitude"),
    LATITUDE("latitude");

    private String name;

    private Fields(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    protected static String[] toStringArray(Fields[] states) {
        String[] names = new String[states.length];

        for (int i = 0; i < states.length; i++) {
            names[i] = states[i].name();
        }

        return names;
    }
}
