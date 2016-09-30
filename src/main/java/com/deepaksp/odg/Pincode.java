package com.deepaksp.odg;

import com.deepaksp.odg.property.URLProperties;

/**
 * @author Deepak
 *
 */
public class Pincode {

    public static PincodeProperties pincodeDetails(String api_key) {
        return new PincodeProperties(URLProperties.PINCODE, api_key);
    }

    /**
     * Latest All India Pin Code Directory including all changes made upto March 2015.
     * 
     * @param api_key
     * @return
     */
    public static PincodeProperties pincodeContactDetails(String api_key) {
        return new PincodeProperties(URLProperties.PINCODE_WITH_CONTACT_DETAILS, api_key);
    }

    /**
     * Presently Latitude and longitude information is available for the Departmental Post offices
     * situated in Mysore and Nanjangud Postal Divisions in Karnataka State. As and when the details
     * are collected in respect of other Post offices, the same will be updated.
     * 
     * @param api_key
     * @return
     */
    public static PincodeProperties pincodeContactLatitudeLongitude(String api_key) {
        return new PincodeProperties(URLProperties.PINCODE_WITH_CONTACT_DETAILS_AND_LOCATION, api_key);
    }

}
