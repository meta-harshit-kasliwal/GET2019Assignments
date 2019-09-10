package com.metacube.EADAssignment7.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.EADAssignment7.services.MailSender;
import com.metacube.EADAssignment7.services.MockMailSender;
import com.metacube.EADAssignment7.services.SmtpMailSender;

@Configuration
public class MailConfig {
	
	@Bean
	public MailSender smtpMailSender() {
		System.out.println("bean method");
		return new SmtpMailSender();
	}
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
	

}
