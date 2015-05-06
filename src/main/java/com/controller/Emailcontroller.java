package com.emc.eas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.eas.json.EmailRequestJson;
import com.emc.eas.json.EmailResponse;
import com.emc.eas.model.EmailTemplate;
import com.emc.eas.model.service.EmailNotificationServiceImpl;

@RestController
@RequestMapping("/email")
public class Emailcontroller {
	
	@Autowired
	EmailNotificationServiceImpl emailNotificationServiceImpl;
	
	
	@RequestMapping(value = "/send", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public EmailResponse sendMail(@RequestBody EmailRequestJson emailRequestJson) {
		EmailResponse emailResponse = new EmailResponse();
		try {
			
			EmailTemplate email = new EmailTemplate();
			if(emailRequestJson.getTo()!= null && emailRequestJson.getBody() != null && emailRequestJson.getFrom() != null
					&& emailRequestJson.getSubject() != null ) {
			email.setTo(emailRequestJson.getTo());
			email.setFrom(emailRequestJson.getFrom());
			email.setBody(emailRequestJson.getBody());
			email.setSubject(emailRequestJson.getSubject());
			emailNotificationServiceImpl.sendMail(email);
			}
			else {
				emailResponse.setStaus("ERROR");
				emailResponse.setMessage("ENTER VALID DETAILS");
				return emailResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
			emailResponse.setStaus("ERROR");
			emailResponse.setMessage("MAIL SENDING FAILED");
			return emailResponse;
		}
		
		emailResponse.setStaus("SUCESS");
		emailResponse.setMessage("MAIL SENT SUCESSFULLY");
		return emailResponse;
		
	}
	
	

}
