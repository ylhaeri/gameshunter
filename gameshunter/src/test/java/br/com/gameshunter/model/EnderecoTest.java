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
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Pais pais = new Pais();

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
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Pais pais = new Pais();

		pais.setNome("Brasil");

		estado.setUf("SP");
		estado.setPais(pais);

		cidade.setNome("São Paulo");
		cidade.setEstado(estado);

		Endereco endereco = new Endereco("Rua Vergueiro", 18,
				"Apto 103, Bloco 2", "Sanola", cidade, estado, "11111-111",
				pais);

		String formatado = "Rua Vergueiro, N.°18 - Apto 103, Bloco 2 - Bairro Sanola "
				+ "São Paulo/SP CEP: 11111-111";

		assertThat(endereco.formatado(), equalTo(formatado));
	}

	@Test
	public void deveFormatarEnderecoComComplementoCorretamente() {
		Cidade cidade = new Cidade();
		Estado estado = new Estado();
		Pais pais = new Pais();

		pais.setNome("Brasil");

		estado.setUf("MG");
		estado.setPais(pais);

		cidade.setNome("Belo Horizonte");
		cidade.setEstado(estado);

		Endereco endereco = new Endereco("Rua Manoel Passos", 315, "Casa",
				"Santa Cruz", cidade, estado, "31150-470", pais);

		String formatado = "Rua Manoel Passos, N.°315 - Casa - Bairro Santa Cruz "
				+ "Belo Horizonte/MG CEP: 31150-470";

		assertThat(endereco.formatado(), equalTo(formatado));
	}
}