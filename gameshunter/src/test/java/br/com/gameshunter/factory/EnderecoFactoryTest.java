package br.com.gameshunter.factory;

import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import br.com.gameshunter.model.Endereco;

public class EnderecoFactoryTest {

	private EnderecoFactory eFac = new EnderecoFactory();

	@Test
	public void deveFazerEnderecoRepetido() {
		Endereco primeiro = eFac.repetido();
		Endereco segundo = eFac.repetido();

		assertThat(primeiro, equalTo(segundo));
	}

	@Test
	public void deveFazerEnderecoDiferente() {
		Endereco primeiro = eFac.comLogradouro("Rua Charimbla");
		Endereco segundo = eFac.comLogradouro("Avenida Shombrali");

		assertThat(primeiro, not(equalTo(segundo)));
	}
}