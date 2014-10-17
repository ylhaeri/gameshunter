package br.com.gameshunter.action;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TesteDeEmailAction {

	
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
		email.addTo("emailaqui@aqui.aqui", "nomedocaraaqui");
		email.send();
	}
}