package br.com.gameshunter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SiteController {

	@RequestMapping(value = "/", method = GET)
	public String index(HttpServletRequest req) {
		return "site/home";
	}

	@RequestMapping(value = "contact", method = GET)
	public String contact() {
		return "site/contact";
	}

	@RequestMapping(value = "how-it-works", method = GET)
	public String howItWorks() {
		return "site/how-it-works";
	}

	@RequestMapping(value = "about", method = GET)
	public String about() {
		return "site/about";
	}
}