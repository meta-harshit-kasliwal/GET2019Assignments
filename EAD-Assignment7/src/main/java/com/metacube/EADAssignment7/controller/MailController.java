package com.metacube.EADAssignment7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.EADAssignment7.services.MailSender;

@RestController
@RequestMapping("/mail")
public class MailController {
	

	 
	// @Autowired  //comment this for setter injection and constructor injection 
	//@Qualifier("smtpMailSender") using qualifier 	
	private MailSender mailSender;
	
	 // Mapping by name
	//private MailSender smtpMailSender; 
	//private MailSender mockMailSender;
	
	/*@Autowired // remove autowired from mailSender
	// setter/getter  injection 
	public void setMailSender(@Qualifier("smtpMailSender")MailSender mailSender) {
		this.mailSender = mailSender;
	}
	*/
	 
	 // for constructor dependency 
	 @Autowired // remove autowired from mailSender
	 public MailController(@Qualifier("mockMailSender")MailSender mailSender) {
		 this.mailSender = mailSender;
		// TODO Auto-generated constructor stub
	}
	 
	
	@GetMapping
	public String show(){
		
		return (mailSender.Send());  // without using anything error two beans were found
	}

	
}
