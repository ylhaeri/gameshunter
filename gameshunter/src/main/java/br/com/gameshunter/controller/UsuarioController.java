package br.com.gameshunter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Sexo;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@RequestMapping("novo")
	public ModelAndView cadastra() {

		ModelAndView modelView = new ModelAndView("usuario/novo");
		Map<String, Sexo> mapa = new HashMap<>();
		for (Sexo sexo : Sexo.values()) {
			mapa.put(sexo.name(), sexo);
		}
		modelView.addObject("sexoList", mapa);
		return modelView;
	}

	@RequestMapping("cadastrado")
	public String cadastrado() {
		return "usuario/cadastrado";
	}
}
