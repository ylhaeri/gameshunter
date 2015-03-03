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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	private UsuarioService service;

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

	@RequestMapping(value = "cadastrado", method = RequestMethod.POST)
	public String cadastrado(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {

			usuario.setConcordaTermos(false);
			return "/usuario/novo";
		} else {
			service.add(usuario);

			return "/usuario/cadastrado";
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody boolean login(@RequestParam("email") String email, @RequestParam("senha") String senha,
			HttpSession session) {

		// FIXME Tá meio estranho esse find, ver se tem alguma forma melhor
		Usuario usuario = service.find(email, senha);
		if (usuario != null) {
			session.setAttribute("usuario", usuario);
			return true;
		}
		return false;
	}

	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String perfil(HttpSession session) {
		// FIXME Parece estranho :x
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