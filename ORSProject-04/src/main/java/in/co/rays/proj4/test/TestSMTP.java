package in.co.rays.proj4.test;

import java.util.HashMap;

import in.co.rays.proj4.util.EmailBuilder;
import in.co.rays.proj4.util.EmailMessage;
import in.co.rays.proj4.util.EmailUtility;

public class TestSMTP {

	public static void main(String[] args) {
//		testUserRegistrationMail();
		testForgetPasswordMail();
	}

	public static void testUserRegistrationMail() {

		// creating map object

		HashMap<String, String> map = new HashMap<String, String>();
		EmailMessage msg = new EmailMessage();

		map.put("login", "aayushibokhre04@gmail.com");
		map.put("passord", "aayushi123");

		msg.setTo(map.get("login"));
		msg.setSubject("User Registration Information");
		msg.setMessage(EmailBuilder.getUserRegistrationMessage(map));
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);
		System.out.println("Mail send successfully");
	}

	public static void testForgetPasswordMail() {

		// Creating map object
		HashMap<String, String> map = new HashMap<String, String>();

		EmailMessage msg = new EmailMessage();

		map.put("login", "aayushibokhre04@gmail.com");
		map.put("password", "aayushi123");
		map.put("firstName", "Aayushi");
		map.put("lastName", "Bokhre");

		msg.setTo(map.get("login"));
		msg.setSubject("Forgot Password");
		msg.setMessage(EmailBuilder.getForgetPasswordMessage(map));
		msg.setMessageType(EmailMessage.HTML_MSG);

		EmailUtility.sendMail(msg);

		System.out.println("Forgot Password mail sent successfully");
	}
}
