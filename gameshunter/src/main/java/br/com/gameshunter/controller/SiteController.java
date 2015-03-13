package br.com.gameshunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

	@RequestMapping("/")
	public String index() {
		return "site/home";
	}

	@RequestMapping(value = "contact")
	public String contact() {
		return "site/contact";
	}

	@RequestMapping(value = "how-it-works")
	public String howItWorks() {
		return "site/how-it-works";
	}

	@RequestMapping(value = "about")
	public String about() {
		return "site/about";
	}
}