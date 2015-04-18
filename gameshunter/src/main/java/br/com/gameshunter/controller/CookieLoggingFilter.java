package br.com.gameshunter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CookieLoggingFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		ResponseWrapper wrappedResponse = new ResponseWrapper(
				(HttpServletResponse) response);

		filterChain.doFilter(request, wrappedResponse);

		// use a real logger here, naturally :)
		System.out.println("Cookies: " + wrappedResponse.cookies);
	}

	private class ResponseWrapper extends HttpServletResponseWrapper {

		private Collection<Cookie> cookies = new ArrayList<Cookie>();

		public ResponseWrapper(HttpServletResponse response) {
			super(response);
		}

		@Override
		public void addCookie(Cookie cookie) {
			super.addCookie(cookie);
			cookies.add(cookie);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Arara");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}