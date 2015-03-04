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
	public UsuarioController(UsuarioService service) {
		this.service = service;
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
		mav.addObject("usuario", new Usuario());

		return mav;
	}

	@RequestMapping(value = "novo&{email}", method = RequestMethod.GET)
	public ModelAndView novo(@PathVariable("email") String email) {
		ModelAndView mav = new ModelAndView("/usuario/novo");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		mav.addObject("usuario", usuario);

		return mav;
	}

	@RequestMapping(value = "cadastrado", method = RequestMethod.POST)
	public String cadastrado(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			usuario.setConcordaTermos(false);
			result.getAllErrors().forEach(System.out::println);
			return "/usuario/novo";
		} else {
			service.add(usuario);

			return "/usuario/cadastrado";
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("path") String path, @Valid Login login, BindingResult result,
			HttpSession session) {

		// TODO fazer o direcionamento para as páginas corretamente. Decidir se
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
			result.rejectValue(
					"email",
					null,
					"Essa conta não existe. Insira outro login ou <a href='/gameshunter/usuario/novo&{email}/' style='text-transform:initial'>cadastre-se.");
			return new ModelAndView("/site/home", "login", login);
		} else if (!usuario.getSenha().equals(login.getSenha())) {
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
	@RequestMapping(value = "teste", method = RequestMethod.GET, produces = "image/jpg")
	public @ResponseBody byte[] teste(HttpSession session) throws IOException {

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		return usuario.getImagem();
	}

	// FIXME Mapeado e feito somente para testes, não acho que o lugar seja
	// apropriado
	@RequestMapping(value = "setFoto", method = RequestMethod.POST)
	public String setFoto(HttpSession session, @RequestParam("file") MultipartFile file) throws IOException {

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuario.setImagem(file.getBytes());
		service.update(usuario);

		return "redirect:/usuario/perfil";
	}
}