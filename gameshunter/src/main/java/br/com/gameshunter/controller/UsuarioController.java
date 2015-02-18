package br.com.gameshunter.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	private static List<String> meses = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream("teste.cfg"));

		String property = prop.getProperty("teste");
		System.out.println(property);
	}

	static {
		String[] month = new DateFormatSymbols(Locale.getDefault()).getMonths();
		for (String string : month) {
			if (string.equals(month[month.length - 1]))
				continue;
			meses.add(string);
		}
	}

	@RequestMapping("novo")
	public ModelAndView novo(HttpSession session) {
		ModelAndView mav = new ModelAndView("usuario/novo");
		mav.addObject("sexoList", Sexo.values());
		mav.addObject("mesList", meses);

		return mav;
	}

	@RequestMapping("cadastrado")
	public ModelAndView cadastrado(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mav;
		if (result.hasErrors()) {
			mav = new ModelAndView("usuario/novo", "sexoList", Sexo.values());
			return mav;
		}
		mav = new ModelAndView("usuario/cadastrado");
		return mav;
	}

	@RequestMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("senha") String senha) {
		System.out.println(email);
		System.out.println(senha);
		return "site/home";
	}
}