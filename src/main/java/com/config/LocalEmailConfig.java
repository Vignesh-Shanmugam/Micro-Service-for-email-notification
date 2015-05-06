
package com.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.model.constants.EmailNotificationConstants;

/**
 * This class is set local profile values for email.
 * @author nitind
 */
@Configuration
@Profile("local")
public class LocalEmailConfig {

   
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