package br.com.gameshunter.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.gameshunter.DAO.JPAUtil;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		new JPAUtil();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		JPAUtil.closeFactory();
	}
}