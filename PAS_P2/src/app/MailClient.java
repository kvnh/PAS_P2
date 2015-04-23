package app;

/**
 * This class sends emails and text to on call team and hospital manager when implemented
 * @author cgollogly
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailClient {

	public void sendMail(String from, String to, String to1,

	String subject, String messageBody) throws MessagingException,
			AddressException

	{

		// Setup mail server

		String host = "smtp.gmail.com";

		String username = "ciaran.gollogly@gmail.com";

		String password = "csc7051pass";

		Properties props = new Properties();

		props.put("mail.smtps.auth", "true");

		// Get a mail session

		Session session = Session.getDefaultInstance(props, null);

		// Define a new mail message

		MimeMessage message = new MimeMessage(session);

		message.setFrom(new InternetAddress(from));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));

		message.setSubject(subject);

		message.setText(messageBody);

		// Send the message

		Transport t = session.getTransport("smtps");

		try {

			t.connect(host, username, password);

			t.sendMessage(message, message.getAllRecipients());

		} finally {

			t.close();

		}

	}

	public static void contactOnCall() {

		try {

			MailClient client = new MailClient();

			String from = "ciaran.gollogly@gmail.com";

			String to = "07900991768@mmail.co.uk";

			String to1 = "c_gollogly@msn.com";

			String subject = "On Call Team";

			String message = "Your assistance is required at the hospital";

			client.sendMail(from, to, to1, subject, message);

		} catch (Exception e) {

			e.printStackTrace(System.out);

		}

	}

}