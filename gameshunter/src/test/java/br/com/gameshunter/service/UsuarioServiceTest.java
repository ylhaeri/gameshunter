package br.com.gameshunter.service;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;

public class UsuarioServiceTest {

	private UsuarioService uService;
	private Usuario usuario;

	@Before
	public void setUp() {
		uService = new UsuarioService(null, null);
		cadastraUmUsuarioExemplo();
	}

	private void cadastraUmUsuarioExemplo() {
		usuario = new Usuario();
		usuario.setEmail("alexfelipevieira@gmail.com");
		usuario.setNome("Alex Felipe Victor Vieira");
		usuario.setCpf("437.072.028-10");
		usuario.setCelular("(11)9323-23232");
		usuario.setApelido("Swanter");
		usuario.setDataNascimento(LocalDate.of(1994, 8, 3));
		usuario.setSexo(Sexo.Masculino);
		usuario.setSenha("felipee");
	}

	@Test
	public void deveRetornarUmUsuarioDoBanco() {
		Usuario recuperado = uService.find("alexfelipevieira@gmail.com", "senha");
		assertThat(usuario, equalTo(recuperado));
	}
}
