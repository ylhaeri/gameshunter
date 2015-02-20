package br.com.gameshunter.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;
import br.com.gameshunter.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	private UsuarioService service;

	/*
	 * static { String[] month = new
	 * DateFormatSymbols(Locale.getDefault()).getMonths(); for (String string :
	 * month) { if (string.equals(month[month.length - 1])) continue;
	 * meses.add(string); } }
	 */
	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}

	@RequestMapping("novo")
	public ModelAndView novo(HttpSession session) {
		ModelAndView mav = new ModelAndView("usuario/novo");
		mav.addObject("usuario", new Usuario());

		return mav;
	}

	@RequestMapping("cadastrado")
	public ModelAndView cadastrado(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mav;
		if (result.hasErrors()) {
			mav = new ModelAndView("usuario/novo", "sexoList", Sexo.values());
			return mav;
		}
		service.add(usuario);
		mav = new ModelAndView("usuario/cadastrado");
		return mav;
	}

	@RequestMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		System.out.println(email);
		System.out.println(senha);
		return "site/home";
	}

	@RequestMapping("perfil")
	public ModelAndView perfil() {
		ModelAndView mav;
		Usuario usuario = new Usuario();
		try{
		usuario = new UsuarioService().find("alexfelipevieira@gmail.com");
		} catch(java.lang.NullPointerException e){
			System.out.println("hu3");
		}
		mav = new ModelAndView("usuario/perfil","teste", usuario);
		return mav;
	}
}