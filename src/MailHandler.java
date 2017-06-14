import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHandler {

	public static void sendMail(String name, String email) {
		String text = "Hello " + name + "!\n" + "Congratulations on coming so far in the hunt.\n"
				+ "Your next clue is pretty difficult. Hope you have your bases clear.\n"
				+ "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAIAAAD2HxkiAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAU0SURBVHhe7dnbjRs7DADQ9JN6tp+tx/VsPzd+6jEjaSjZvkjgcz4tkeKQEhZIfgEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADAX+rr9N/N6ev+y9/vyZr/xU/+N6VOX2l3j0fIO/z+/rl3OdHuHo+Ql8sv8Of79/03+jxCXk2DJ3mEvFj6O6i/QR4hL6a/szxCXkx/Z3mEvJj+zvIIeTH9nTXo2H4p/dL6t+fG/wzF/ol6OrBRc1HZzeACLIfnXf3q8p5uBc3vHRW8D+icv/uMvshgagdlH5w9f94HSb3bX4J6adPkoqnt6RR6A1gNrAobJHl9eG7Cvl0XB+vjD26FbLpe2dc32l1rl98RKvvg7N4d4Cz1bj+WcmnX4qKpaUbbFEVQc+irgbmw73uGaldZ68vD8+p+LV/WxrHVTd6tX9JufywjyrXi95mrXXxXo7ye+bLzQRPHfLZBx/LS/bIWW76+y0d46t6FlKN1XVYD09pVa9R5xxvDt2tpoZFymLFp+KL7RfTkApr5OubLPhv1gZZBx4q5TQ2hkpLMJhgEloV1Bp2v8MvDO88jZW2knG9COqMbMTpvJ39yuIKz+bKvpirjbNCxPLnJKVSWR9IPzIX16xr8IXky/Gz/RNIvje3jXE2RpsUbG/ngvYWyb+KFcTPo2NrstpZH0g9MK6O63hZ+VT/D0RPcbA05OPwmmjclmyjgbKHsu1D1FAYdS0vTYygGn4VGEgoMTbm/6cnwu+LhPfa2t4aOqwTv/yPxcFc6fXaK82U/rEd+qkHH0lJkfOnidHVGshAYmnL/Jj8ZnqQ8N0ffF38Em8SH+t+RM00+wZWyH0L9pTDoWLSZrTuTQyIHFCKBocLe/wirD+jmCp1WK9KG9DLnPP/rS3oi9EMNOhZqZrqsvUn3siwHzhb2vkeYEl11sqVN8YcQKvBQri5+crZQ9sNryv8kg45Fmnk8q06W5cCzSGHvf4SPND8/w52R17yxELKTPnIxyRM1hPpLYdCxQDOPR5V21FmWAy9CU+6f8GT4VbU83puO637qTqjCgdy7iUM3Fsq+e7b6zzPoWKCZx1vSjnrLcuBFoLD3PsLdYkrZ2j1cbMqPaFRizyue4Nl82Xeh/lIYdCzQzKMtxX2otywHXoSmvHsoyZPhRW1FgpS0cWXT2vDEyijdWNG56djaQtlXof5SGHQs0Mw88dbA8xQvqizLgRehKfdf0XPhufJNeErb+KL8Qa3Pvfo6dRo0KnMTFA2rPYrbB8yXfRHqL4VBx0LNzHOqB/W4DadTJ8tyYLCwdB139+eZ8HzJ99dytFYsnm3W7wVtyhlF5I+ogoqQ0bdVymP2QfNlB/tLYdCxYDOrOdUuU+tnWQ4MFZayd+/vfHiueJf06mA9HdzWKOcgolddQDqsjGo3ZLbsUH8pDDo208zdoNLtOMiyEhgqrPmKrlbDc6m7lEnxOb3sxZZkVEnncfW7ElKEPwKHRUyUnXaOEwIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAvMWvX38Av/9NjeZJbgQAAAAASUVORK5CYII=\n"
				+ "\n" + "";

		final String user = "noreply@bitrex.in";
		final String pass = "bitrex17";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.zoho.com");// change accordingly
		props.put("mail.smtp.socketFactory.port", "");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.useSsl", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		// 2nd step)compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Missing Bits");
			message.setText(text);

			// 3rd step)send message
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
