package br.com.gameshunter.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteDeEmail {

	public static void main(String[] args) throws EmailException {

		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(
				"testeghunter@gmail.com", "xbifexbacon"));
		email.setSSLOnConnect(true);
		email.setSubject("Teste de email do hue");
		email.setFrom("testeghunter@gmail.com", "T Games Hunter");
		email.setMsg("Teste de email básico");
		email.addTo("alexfelipevieira@gmail.com",
				"Alex Felipe Vieira the lelek of hue");
		email.send();
	}
}