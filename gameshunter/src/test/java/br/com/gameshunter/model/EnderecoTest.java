package br.com.gameshunter.model;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;

public class EnderecoTest {

	private Endereco endereco;

	@Before
	public void setUp() {

		endereco = new Endereco();
	}

	@Test
	public void deveCadastrarCepCorretamente() {

		endereco.setCep("11111-111");
		assertThat(endereco.getCep(), equalTo("11111-111"));
	}

	@Test
	public void deveCadastrarLogradouroCorretamente() {

		endereco.setLogradouro("Avenida Barreilinhos Churimplante");
		assertThat(endereco.getLogradouro(),
				equalTo("Avenida Barreilinhos Churimplante"));
	}

	@Test
	public void deveCadastrarNumeroCorretamente() {

		endereco.setNumero(2763);
		assertThat(endereco.getNumero(), equalTo(2763));
	}

	@Test
	public void deveCadastrarComplementoCorretamente() {

		endereco.setComplemento("apto 302 bloco 2");
		assertThat(endereco.getComplemento(), equalTo("apto 302 bloco 2"));
	}

	@Test
	public void deveCadastrarBairroCorretamente() {

		endereco.setBairro("Paralelepipedo");
		assertThat(endereco.getBairro(), equalTo("Paralelepipedo"));
	}

	@Test
	public void deveCadastrarCidadeCorretamente() {

		endereco.setCidade("São Paulo");
		assertThat(endereco.getCidade(), equalTo("São Paulo"));
	}

	@Test
	public void deveCadastrarEstadoCorretamente() {

		endereco.setEstado("São Paulo");
		assertThat(endereco.getEstado(), equalTo("São Paulo"));
	}

	@Test
	public void deveCadastrarPaisCorretamente() {

		endereco.setPais("Brasil");
		assertThat(endereco.getPais(), equalTo("Brasil"));
	}

	@Test
	public void deveCompararEnderecosCorretamente() {
		assertThat(endereco, equalTo(new Endereco()));
	}
}