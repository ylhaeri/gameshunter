package br.com.gameshunter.config;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.gameshunter.model.User;
import br.com.gameshunter.schedule.AraraScheduled;

@Configuration
@EnableTransactionManagement
public class SpringConfig {

	@Bean(initMethod = "init")
	public User usuario() {
		return new User();
	}

	@Bean
	public AraraScheduled arara() {
		return new AraraScheduled();
	}

	@Bean
	@Scope("prototype")
	public SimpleEmail simpleEmail() {
		// FIXME Ajeitar a configuração, só fiz algo que pega. Não sei se da
		// para melhorar ou não
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator(
				"testeghunter@gmail.com", "xbifexbacon"));
		email.setSSLOnConnect(true);
		try {
			email.setFrom("testeghunter@gmail.com", "GamesHunter");
		} catch (EmailException e) {
			System.out.println("E-mail inválido");
		}
		return email;
	}

	@Bean(name = "GamesHunterFactory")
	public LocalEntityManagerFactoryBean gamesHunterFactory() {
		LocalEntityManagerFactoryBean gamesHunterFactoryBean = new LocalEntityManagerFactoryBean();
		gamesHunterFactoryBean.setPersistenceUnitName("gameshunter");
		return gamesHunterFactoryBean;
	}

	@Bean(name = "GamesHunterManager")
	public JpaTransactionManager gamesHunterManager() {
		JpaTransactionManager gamesHunterTransactionManager = new JpaTransactionManager();
		gamesHunterTransactionManager.setPersistenceUnitName("gameshunter");
		return gamesHunterTransactionManager;
	}
}