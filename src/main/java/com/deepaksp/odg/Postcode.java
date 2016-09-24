package com.deepaksp.odg;

import com.deepaksp.odg.property.URLProperties;

/**
 * @author Deepak
 *
 */
public class Postcode {

    public static PostcodeProperties withContactDetails() {
        return new PostcodeProperties(URLProperties.CONTACT_DETAILS);
    }

}
