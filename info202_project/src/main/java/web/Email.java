/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author teewa743
 */
public class Email {
	public static void main(String[] args) throws EmailException{
	SimpleEmail email = new SimpleEmail();
	email.setHostName("localhost");
	email.setSmtpPort(2525);
	email.setFrom("user@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("foo@bar.com");
	email.send();
	
}
}
