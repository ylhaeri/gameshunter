package br.com.gameshunter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Teste extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("gameshunter/") || uri.endsWith("login") || uri.contains("resources")) {
			return true;
		}

		if (request.getSession().getAttribute("usuario") != null) {
			return true;
		}
		response.sendRedirect("/gameshunter/usuario/login");
		return false;
	}
}