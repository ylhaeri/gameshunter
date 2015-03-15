package br.com.gameshunter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
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
public class UserController {

	@RequestMapping("ararinha")
	public @ResponseBody byte[] testa(HttpSession session) throws IOException {
		File file = new File(session.getServletContext().getRealPath(
				"/resources/img/Brazil-Flag-icon.png"));
		InputStream is = new FileInputStream(file);
		return IOUtils.toByteArray(is);
	}

	@RequestMapping("ararinha2")
	public @ResponseBody byte[] testas(HttpSession session) throws IOException {
		File file = new File(session.getServletContext().getRealPath(
				"/resources/img/United-States-Flag-icon.png"));
		InputStream is = new FileInputStream(file);
		return IOUtils.toByteArray(is);
	}

	private UserService service;
	private User user;

	@Autowired
	public UserController(UserService service, User user) {
		this.service = service;
		this.user = user;
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

			user.setAgreeTermsOfService(false);
			return "/user/signup";
		} else if (user.getPassword().length() > 50) {

			user.setAgreeTermsOfService(false);
			// FIXME existe um problema com o valor máximo
			result.rejectValue("password", null,
					"Deve ter entre 6 e 50 caracteres.");
			return "/user/signup";
		} else {

			user.generatePassword();
			service.add(user);
			return "/user/registered";
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("path") String path,
			@Valid Login login, BindingResult result, HttpSession session) {

		// TODO fazer o redirecionamento para as páginas corretamente. Decidir
		// se
		// vai ser estático ou baseado na página onde o usuário estava quando
		// tentou logar. Creio que o ideal é guardar no login as últimas
		// visitadas pelo usuário, pra dai decidir onde redirecionar. Passar as
		// mensagens de erro para o validation messages, mas não consegui
		// colocar as chaves normalmente, precisa pesquisar como faz, caso não
		// conseguir precisa ser retirado da classe do sistema, acho que é só
		// declarar o resource bundle do spring, não tenho certeza
		if (result.hasErrors())
			return new ModelAndView("/site/home");
		User user = service.find(login.getEmail());
		if (user == null) {
			result.rejectValue("email", "login.email.not.found",
					new Object[] { login.getEmail() },
					// TODO resolver mensagem em português o.o'
					"Essa conta não existe. Insira outro login ou cadastre-se.");
			return new ModelAndView("/site/home", "login", login);
		} else if (!user.isPasswordEqual(login.getPassword())) {
			result.rejectValue("email", "login.password.not_match", null,
			// TODO resolver mensagem em português o.o'
					"Usuário ou senha incorretos. Verifique os seus dados e tente novamente.");
			return new ModelAndView("/site/home", "login", login);
		} else {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:" + path);
		}
	}

	@RequestMapping(value = "account", method = RequestMethod.GET)
	public String profile(HttpSession session) {
		// FIXME Parece estranho :x Tem que trocar esse if por um interceptor,
		// vamos ter que filtar esse interceptor todas as páginas que o usuário
		// não pode entrar sem estar logado, provavelmente resolve o problema de
		// redirecionamento quando deslogar também.
		if (session.getAttribute("user") == null)
			return "redirect:/";
		System.out.println(user.getEmail());

		return "/user/account";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public @ResponseBody void logout(HttpSession session) {

		session.removeAttribute("user");
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado, provavelmente a forma como a foto é pegava será alterada
	@RequestMapping(value = "teste", method = RequestMethod.GET, produces = "image/png")
	public @ResponseBody byte[] teste(HttpSession session) throws IOException {

		User usuario = (User) session.getAttribute("user");

		return usuario.getProfilePicture();
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado
	@RequestMapping(value = "setFoto", method = RequestMethod.POST)
	public String setFoto(HttpSession session,
			@RequestParam("file") MultipartFile file) throws IOException {

		User usuario = (User) session.getAttribute("user");
		usuario.setProfilePicture(file.getBytes());
		service.update(usuario);

		return "redirect:/user/account";
	}
}