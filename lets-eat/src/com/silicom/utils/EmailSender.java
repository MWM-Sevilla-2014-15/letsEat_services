package com.silicom.utils;

import	java.io.IOException;	
import java.io.UnsupportedEncodingException;
import	java.util.Properties;	

import	javax.mail.Message;	
import	javax.mail.MessagingException;	
import	javax.mail.Session;	
import	javax.mail.Transport;	
import	javax.mail.internet.AddressException;	
import	javax.mail.internet.InternetAddress;	
import	javax.mail.internet.MimeMessage;	

import com.silicon.entities.User;

public class EmailSender {

	public static String sendEmail (User user) throws UnsupportedEncodingException{
		String msg = PropUtil.GP_OK;
		Properties props = new Properties();	
		Session	session	= Session.getDefaultInstance(props,	null);	
		try	{	
			Message	email	= new MimeMessage(session);	
			email.setFrom(new	InternetAddress("thisisgod@com-silicon-letseat.appspotmail.com",	"Let's Eat Servicio de Recuperacion de Claves"));	
			email.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail(), user.getName()));	
			email.setSubject("Recuperacion de su Clave Let's Eat");	
			email.setText("Estimado "+ user.getName() +", tal y como nos ha solcitado adjunto su clave de acceso :" +user.getPass());	
			Transport.send(email);
		} catch	(AddressException e) {	
			msg = PropUtil.GP_E_IE;		
		} catch	(MessagingException	e) {	
			e.printStackTrace();
		}
		return msg;
	}
}