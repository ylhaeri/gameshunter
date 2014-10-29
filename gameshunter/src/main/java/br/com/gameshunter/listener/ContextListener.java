package br.com.gameshunter.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out
				.println("Listener iniciado!!!! hueuhehuehueuehuehueehueu brbrbrbrbrbrbbrbrbrbasdjsaadsids asfasd");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}