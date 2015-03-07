package br.com.gameshunter.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	private UsuarioService service;
	private Usuario usuario;

	// private final RequestMappingHandlerMapping handlerMapping;
	//
	// @Autowired
	// public UsuarioController(RequestMappingHandlerMapping handlerMapping,
	// UsuarioService service) {
	// this.handlerMapping = handlerMapping;
	// this.service = service;
	// }
	//
	// @RequestMapping(value = "/endpointdoc", method = RequestMethod.GET)
	// public void show(Model model) {
	// Map<RequestMappingInfo, HandlerMethod> handlerMethods =
	// handlerMapping.getHandlerMethods();
	// handlerMethods.forEach((r, h) -> {
	// System.out.println(r.getPatternsCondition());
	// System.out.println(h.getMethod());
	// System.out.println("___________________");
	// });
	// }

	@Autowired
	public UsuarioController(UsuarioService service, Usuario usuario) {
		this.service = service;
		this.usuario = usuario;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	/*
	 * static { String[] month = new
	 * DateFormatSymbols(Locale.getDefault()).getMonths(); for (String string :
	 * month) { if (string.equals(month[month.length - 1])) continue;
	 * meses.add(string); } }
	 */

	@RequestMapping(value = "novo", method = RequestMethod.GET)
	public ModelAndView novo() {
		ModelAndView mav = new ModelAndView("/usuario/novo");
		mav.addObject("usuario", usuario);

		return mav;
	}

	@RequestMapping(value = "novo&{email}", method = RequestMethod.GET)
	public ModelAndView novo(@PathVariable("email") String email) {
		ModelAndView mav = new ModelAndView("/usuario/novo");
		usuario.setEmail(email);
		mav.addObject("usuario", usuario);

		return mav;
	}

	@RequestMapping(value = "cadastrado", method = RequestMethod.POST)
	public String cadastrado(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {

			usuario.setAgreeTermsOfService(false);
			return "/usuario/novo";
		} else if (usuario.getPassword().length() > 50) {

			usuario.setAgreeTermsOfService(false);
			result.rejectValue("password", null,
					"Deve ter entre 6 e 50 caracteres.");
			return "/usuario/novo";
		} else {

			usuario.generatePassword();
			service.add(usuario);
			return "/usuario/cadastrado";
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
		Usuario usuario = service.find(login.getEmail());
		if (usuario == null) {
			result.rejectValue("email", "login.email.not.found",
					new Object[] { login.getEmail() },
					"Essa conta não existe. Insira outro login ou cadastre-se.");
			// FIXME deve pegar a mensagem da validation messages
			return new ModelAndView("/site/home", "login", login);
		} else if (!usuario.getPassword().equals(login.getSenha())) {
			result.rejectValue("email", null,
					"Usuário ou senha incorretos. Verifique os seus dados e tente novamente.");
			return new ModelAndView("/site/home", "login", login);
		} else {
			session.setAttribute("usuario", usuario);
			return new ModelAndView("redirect:" + path);
		}
	}

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String perfil(HttpSession session) {
		// FIXME Parece estranho :x Tem que trocar esse if por um interceptor,
		// vamos ter que filtar esse interceptor todas as páginas que o usuário
		// não pode entrar sem estar logado, provavelmente resolve o problema de
		// redirecionamento quando deslogar também.
		if (session.getAttribute("usuario") == null)
			return "redirect:/";

		return "/usuario/perfil";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public @ResponseBody void logout(HttpSession session) {

		session.removeAttribute("usuario");
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado
	@RequestMapping(value = "teste", method = RequestMethod.GET, produces = "image/png")
	public @ResponseBody byte[] teste(HttpSession session) throws IOException {

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		return usuario.getImage();
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado
	@RequestMapping(value = "setFoto", method = RequestMethod.POST)
	public String setFoto(HttpSession session,
			@RequestParam("file") MultipartFile file) throws IOException {

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuario.setImage(file.getBytes());
		service.update(usuario);

		return "redirect:/usuario/perfil";
	}
}