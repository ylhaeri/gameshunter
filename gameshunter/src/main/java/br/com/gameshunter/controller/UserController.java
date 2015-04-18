package br.com.gameshunter.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Login;
import br.com.gameshunter.model.User;
import br.com.gameshunter.service.UserService;

@Controller
@RequestMapping("user")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserController {

	private User user;
	private UserService service;
	DefaultWebSecurityManager securityManager;
	LightCookieRememberMeManager rememberMeManager;

	@Autowired
	public UserController(User user, UserService service,
			DefaultWebSecurityManager securityManager) {
		this.user = user;
		this.service = service;
		this.securityManager = securityManager;
		this.rememberMeManager = (LightCookieRememberMeManager) securityManager
				.getRememberMeManager();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView mav = new ModelAndView("/user/signup");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "signup&{email}", method = RequestMethod.GET)
	public ModelAndView signUp(@PathVariable("email") String email) {
		ModelAndView mav = new ModelAndView("/user/new");
		user.setEmail(email);
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping(value = "registered", method = RequestMethod.POST)
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

	@RequestMapping(value = "signin", method = GET)
	public String signin() {
		return "/user/signin";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("path") String path,
			@Valid Login login, BindingResult result,
			HttpServletResponse response) {

		UsernamePasswordToken token = new UsernamePasswordToken(
				login.getEmail(), login.getPassword());
		token.setRememberMe(true);
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
		rememberMeManager.getCookie();
		return new ModelAndView("redirect:/");
	}

	@RequiresUser
	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String profile(HttpSession session) {
		// FIXME Parece estranho :x Tem que trocar esse if por um interceptor,
		// vamos ter que filtar esse interceptor todas as páginas que o usuário
		// não pode entrar sem estar logado, provavelmente resolve o problema de
		// redirecionamento quando deslogar também.
		if (session.getAttribute("user") == null)
			return "redirect:/";
		return "/user/account";
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado, provavelmente a forma como a foto é pegava será alterada
	@RequestMapping(value = "getPicture", method = RequestMethod.GET)
	public @ResponseBody byte[] getPicture(HttpSession session) {

		User usuario = (User) session.getAttribute("user");

		return usuario.getProfilePicture();
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado
	@RequestMapping(value = "setPicture", method = RequestMethod.POST)
	public String setPicture(HttpSession session,
			@RequestParam("file") MultipartFile file) throws IOException {

		User usuario = (User) session.getAttribute("user");
		usuario.setProfilePicture(file.getBytes());
		service.update(usuario);

		return "redirect:/user/account";
	}
}