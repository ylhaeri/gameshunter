package br.com.gameshunter.config;

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
@ComponentScan(basePackages = "br.com.gameshunter.service")
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

	@Bean(name = "GamesHunter")
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

	@Bean(name = "Security")
	public LocalEntityManagerFactoryBean securityFactory() {
		LocalEntityManagerFactoryBean gamesHunterFactoryBean = new LocalEntityManagerFactoryBean();
		gamesHunterFactoryBean.setPersistenceUnitName("security");
		return gamesHunterFactoryBean;
	}

	@Bean(name = "SecurityManager")
	public JpaTransactionManager secutiryManager() {
		JpaTransactionManager gamesHunterTransactionManager = new JpaTransactionManager();
		gamesHunterTransactionManager.setPersistenceUnitName("security");
		return gamesHunterTransactionManager;
	}
}