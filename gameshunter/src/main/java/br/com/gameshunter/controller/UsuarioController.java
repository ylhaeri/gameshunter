package br.com.gameshunter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@RequestMapping("novo")
	public String cadastra() {
		return "usuario/novo";
	}
}