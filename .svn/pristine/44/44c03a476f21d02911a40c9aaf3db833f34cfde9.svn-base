/**-------------------------------------+----------------------------------------------------------
 * CloudEmailConfig.java
 *
 * Description:  This class is set cloud profile values for email.
 * History:
 *
 * Change History:
 * Revision     Date        Dev     Comments
 * ------------------------------------------------------------------------------------------------
 * 1.0          01.18.2015  nitind     Initial creation CloudEmailConfig.java
 *
 *
 *
 * Copyright (c) 2009 - 2012. EMC Corporation. All Rights Reserved.
 * This software contains the intellectual property of EMC Corporation or is licensed to
 * EMC Corporation from third parties. Use of this software and the intellectual property
 * contained therein is expressly limited to the terms and conditions of the License
 * Agreement under which it is provided by or on behalf of EMC.
 *
 **************************************************************************************************/

package com.emc.eas.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.emc.eas.model.constants.EmailNotificationConstants;

/**
 * This class is set cloud profile values for email.
 * @author nitind
 */
@Configuration
@Profile("cloud")
public class CloudEmailConfig extends AbstractCloudConfig {

    

    /**
     * mail server host name.
     */
    @Value("${mail.host}")
    private String mailHost;

    /**
     * mail service protocol.
     */
    @Value("${mail.protocol}")
    private String mailProtocol;

    /**
     * mail service username/password authorization.
     */
    @Value("${mail.auth}")
    private String mailAuth;

    /**
     * JavaMailSender to facilitate sending mails.
     * @return JavaMailSender
     */
    @Bean
    public JavaMailSender javaMailService() {
       
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(mailHost);

        Properties properties = new Properties();
        properties.setProperty(EmailNotificationConstants.MAIL_TRANSPORT_PROTOCOL, mailProtocol);
        properties.setProperty(EmailNotificationConstants.MAIL_SMTP_AUTH, mailAuth);

        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }
}