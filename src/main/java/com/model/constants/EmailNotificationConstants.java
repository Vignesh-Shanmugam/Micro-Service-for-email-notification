
package com.model.constants;

/**
 * This class is used for constants.
 */
public final class EmailNotificationConstants {

    /** error code for mail send fail. */
    public static final String ERROR_MAIL_SEND_FAILS = "MAIL_SEND_FAILS";

    /** constant for MAIL_TRANSPORT_PROTOCOL. */
    public static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";

    /** constant for MAIL_SMTP_AUTH. */
    public static final String MAIL_SMTP_AUTH = "mail.smtp.auth";

    /** constant for EMAIL_LIST_SEPARATOR. */
    public static final String EMAIL_LIST_SEPARATOR = ",";

    /** constant for NUMBER_ZERO. */
    public static final int NUMBER_ZERO = 0;

    /** constant for NUMBER_ONE. */
    public static final int NUMBER_ONE = 1;
    
    /**
     * The Constant FEATURE_EXTERNAL_GENERAL_ENTITY.
     */
    public static final String FEATURE_EXTERNAL_GENERAL_ENTITY =
            "http://xml.org/sax/features/external-general-entities";

    /**
     * The Constant FEATURE_DISALLOW_DOCTYPE_DECLARE.
     */
    public static final String FEATURE_DISALLOW_DOCTYPE_DECLARE =
            "http://apache.org/xml/features/disallow-doctype-decl";

    /** The Constant XML_UNMARSHALLING_FAILED. */
    public static final String ERROR_CODE_XML_UNMARSHALLING_FAILED = "XML_UNMARSHALLING_FAILED";
    
    /**
     * private constructor to restrict instantiation.
     */
    private EmailNotificationConstants() {
    }
}
