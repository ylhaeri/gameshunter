package br.com.gameshunter.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {


	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ExceptionHandler(UnauthenticatedException.class)
	public ModelAndView unauthenticatedUser() {
		return new ModelAndView("redirect:/user/login");
	}
}