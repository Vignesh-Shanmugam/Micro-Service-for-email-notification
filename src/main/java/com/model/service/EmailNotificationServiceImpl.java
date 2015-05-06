
package com.model.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.model.EmailTemplate;
import com.model.constants.EmailNotificationConstants;

/**
 * This class is used to process message received from queue.
 * @author philic3
 */
@Service
public class EmailNotificationServiceImpl  {

   
    @Autowired
    private JavaMailSender mailSender;

    /**
     * method to send email.
     * @param emailTemplate received message
     * @throws TesException TesException
     */
    public void sendMail(EmailTemplate emailTemplate) {
        try {

           

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(emailTemplate.getFrom());

            String[] recipientsArray = null;
            String recipients = emailTemplate.getTo();
            if (!StringUtils.isEmpty(recipients)) {
                recipientsArray = generateRecipients(recipients);
                if (recipientsArray != null) {
                    helper.setTo(recipientsArray);
                } else {
                    helper.setTo(recipients);
                }
            }

            recipients = emailTemplate.getCc();
            if (!StringUtils.isEmpty(recipients)) {
                recipientsArray = generateRecipients(recipients);
                if (recipientsArray != null) {
                    helper.setCc(recipientsArray);
                } else {
                    helper.setCc(recipients);
                }
            }

            recipients = emailTemplate.getBcc();
            if (!StringUtils.isEmpty(recipients)) {
                recipientsArray = generateRecipients(recipients);
                if (recipientsArray != null) {
                    helper.setBcc(recipientsArray);
                } else {
                    helper.setBcc(recipients);
                }
            }

            helper.setSubject(emailTemplate.getSubject());
            helper.setText(emailTemplate.getBody(), true);
            //helper.setText(StringEscapeUtils.unescapeXml(emailTemplate.getBody()), true);
            /*if (emailTemplate.getAttachments() != null) {
                for (Attachment attachment : emailTemplate.getAttachments()) {
                    if (attachment.getFileName() != null && attachment.getBase64Content() != null) {
                        ByteArrayResource byteArrayResouce = new ByteArrayResource(
                                Base64.decodeBase64(attachment.getBase64Content().getBytes()));
                        helper.addAttachment(attachment.getFileName(), byteArrayResouce);
                    }
                }
            }*/
            mailSender.send(message);
          
        } catch (MessagingException e) {
           e.printStackTrace();
        }
    }

    /**
     * method to generate recipients.
     * @param recipients comma separated String of all Recipients.
     * @return String Array of all Recipients.
     */
    private String[] generateRecipients(String recipients) {
        String[] recipientsArray = null;
        if (recipients.contains(EmailNotificationConstants.EMAIL_LIST_SEPARATOR)) {
            
            recipientsArray = recipients.split(EmailNotificationConstants.EMAIL_LIST_SEPARATOR);
        }
        return recipientsArray;
    }
}