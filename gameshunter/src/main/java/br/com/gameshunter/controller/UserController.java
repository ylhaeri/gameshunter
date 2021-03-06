package br.com.gameshunter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Login;
import br.com.gameshunter.model.User;
import br.com.gameshunter.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	private User user;
	private UserService service;

	@Autowired
	public UserController(User user, UserService service) {
		this.user = user;
		this.service = service;
	}

	@RequestMapping(value = "signup", method = GET)
	public ModelAndView signUp() {
		
		ModelAndView mav = new ModelAndView("/user/signup");
		mav.addObject("user", user);
		
		return mav;
	}

	@RequestMapping(value = "signup&{email}", method = GET)
	public ModelAndView signUp(@PathVariable("email") String email) {
		
		ModelAndView mav = new ModelAndView("/user/signup");
		user.setEmail(email);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping(value = "registered", method = POST)
	public String registered(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {

			result.getAllErrors().forEach(System.out::println);
			user.setAgreeTermsOfService(false);
			return "/user/signup";
		} else {

			service.add(user);
			return "/user/registered";
		}
	}

	@RequestMapping(value = "login", method = GET)
	public String signin() {
		return "/user/login";
	}

	@RequestMapping(value = "login", method = POST)
	public ModelAndView login(
			@Valid Login login,
			BindingResult result,
			@RequestParam(value = "rememberMe", defaultValue = "false") boolean remember) {

		UsernamePasswordToken token = new UsernamePasswordToken(
				login.getEmail(), login.getPassword());
		token.setRememberMe(remember);

		Subject subject = SecurityUtils.getSubject();

		try {
			subject.login(token);
		} catch (UnknownAccountException uae) {
			System.out.println("Não existe essa conta");
		} catch (IncorrectCredentialsException ice) {
			System.out.println("Senha errada");
		} catch (LockedAccountException lae) {
			System.out.println("Conta bloqueada");
		} catch (AuthenticationException ae) {
			// unexpected condition error?
			System.out.println("Algum hue");
		}

		return new ModelAndView("redirect:/");
	}

	@RequiresUser
	@RequestMapping(value = "account", method = GET)
	public ModelAndView account() {

		Subject subject = SecurityUtils.getSubject();
		User user = service.find(subject.getPrincipal());

		return new ModelAndView("/user/account", "user", user);
	}

	@RequiresUser
	@RequestMapping(value = "profile-picture", method = GET)
	public @ResponseBody byte[] getPicture(HttpServletResponse response) {

		Subject subject = SecurityUtils.getSubject();
		User user = service.find(subject.getPrincipal());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=alex.gay";
		response.setHeader(headerKey, headerValue);
		return user.getProfilePicture();
	}

	@RequiresUser
	@RequestMapping(value = "profile-picture", method = POST)
	public String setPicture(@RequestParam("file") MultipartFile file)
			throws IOException {

		Subject subject = SecurityUtils.getSubject();
		User user = service.find(subject.getPrincipal());
		user.setProfilePicture(file.getBytes());
		byte[] bytes = file.getBytes();
		System.out.println("Bytes " + bytes[0]);
		service.update(user);

		return "redirect:/user/account";
	}
}