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
	public void deveCadastrarDadosCorretamente() {

		Integer id = 1;
		String logradouro = "Avenida Barreilinhos Churimplante";
		Integer numero = 2763;
		String cep = "11111-111";
		String complemento = "Apto 302, Bloco 2";
		String bairro = "Paralelepipedo";
		String cidade = "São Paulo";
		String estado = "São Paulo";
		String pais = "Brasil";

		endereco.setId(id);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setCep(cep);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setPais(pais);

		assertThat(endereco.getId(), equalTo(id));
		assertThat(endereco.getLogradouro(), equalTo(logradouro));
		assertThat(endereco.getNumero(), equalTo(numero));
		assertThat(endereco.getCep(), equalTo(cep));
		assertThat(endereco.getComplemento(), equalTo(complemento));
		assertThat(endereco.getBairro(), equalTo(bairro));
		assertThat(endereco.getCidade(), equalTo(cidade));
		assertThat(endereco.getEstado(), equalTo(estado));
		assertThat(endereco.getPais(), equalTo(pais));
	}

	@Test
	public void deveCompararEnderecosCorretamente() {
		assertThat(endereco, equalTo(new Endereco()));
	}

	@Test
	public void deveFormatarEnderecoSemComplementoCorretamente() {
		Endereco endereco = new Endereco("Rua Vergueiro", 18,
				"Apto 103, Bloco 2", "Sanola", "São Paulo", "SP", "11111-111",
				"Brasil");
		String formatado = "Rua Vergueiro, 18, Apto 103, Bloco 2 - Bairro Sanola - "
				+ "11111-111 - São Paulo, SP - Brasil";

		assertThat(endereco.formatado(), equalTo(formatado));
	}

	@Test
	public void deveFormatarEnderecoComComplementoCorretamente() {
		Endereco endereco = new Endereco("Rua Vergueiro", 18, "", "Sanola",
				"São Paulo", "SP", "11111-111", "Brasil");
		String formatado = "Rua Vergueiro, 18 - Bairro Sanola - "
				+ "11111-111 - São Paulo, SP - Brasil";

		assertThat(endereco.formatado(), equalTo(formatado));
	}
}