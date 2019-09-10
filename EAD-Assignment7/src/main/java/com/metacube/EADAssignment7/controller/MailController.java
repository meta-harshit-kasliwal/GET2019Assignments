package com.metacube.EADAssignment7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.EADAssignment7.services.MailSender;

@RestController
public class MailController {
	
	private MailSender mailSender;

	/**
	 * using constructor	
	 */
/*	@Autowired
	public MailSenderController(MailSender mailSender) {
		this.mailSender = mailSender;
		System.out.println("--constructor--");
	}
*/	
	/**
	 * using setter
	 */
	/*@Autowired
	public void setMailSender(MailSender mailSener) {
		this.mailSender = mailSender;
	}*/
	
	/**
	 * by qualifier
	 */
	/*@Autowired
	public void setMailSender(@Qualifier("smtpMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	/**
	 * by qualifier
	 */
	/*@Autowired
	public void setMailSender(@Qualifier("mockMailSender") MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	/**
	 * method by name
	 * @param smtpMailSender
	 */
	@Autowired
	public void setMailSender(MailSender smtpMailSender) {
		this.mailSender = smtpMailSender;
	}
	
	@RequestMapping("/sendmail")
	public String getMail() {
		System.out.println("getmail method");
		return mailSender.Send();
	}
}
