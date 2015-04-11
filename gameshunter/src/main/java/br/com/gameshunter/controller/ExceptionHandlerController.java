package br.com.gameshunter.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(UnauthenticatedException.class)
	public ModelAndView unauthenticatedUser() {
		return new ModelAndView("redirect:/user/login");
	}
}