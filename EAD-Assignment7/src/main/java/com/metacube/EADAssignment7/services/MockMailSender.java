package com.metacube.EADAssignment7.services;

public class MockMailSender implements  MailSender {

	@Override
	public String Send() {
		
		return "mock mail Sender";
	}
	

}
