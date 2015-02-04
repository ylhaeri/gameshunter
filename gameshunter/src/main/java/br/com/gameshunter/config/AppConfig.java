package br.com.gameshunter.config;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Login;
import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.schedule.Arara;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "br.com.gameshunter" })
public class AppConfig {

	@Bean(initMethod = "init")
	@Scope("prototype")
	public Usuario usuario() {
		return new Usuario();
	}

	@Bean(initMethod = "init")
	@Scope("prototype")
	public Endereco endereco() {
		return new Endereco();
	}

	@Bean(initMethod = "init")
	@Scope("prototype")
	public Login login() {
		return new Login();
	}

	@Bean
	public Arara arara() {
		return new Arara();
	}

	@Bean
	@Scope("prototype")
	public SimpleEmail simpleEmail() {
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("testeghunter@gmail.com", "xbifexbacon"));
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