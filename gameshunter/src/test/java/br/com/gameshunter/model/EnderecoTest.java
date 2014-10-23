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

		String cep = "11111-111";

		endereco.setCep(cep);

		assertThat(endereco.getCep(), equalTo(cep));
	}

	@Test
	public void deveCadastrarLogradouroCorretamente() {

		String logradouro = "Avenida Barreilinhos Churimplante";

		endereco.setLogradouro(logradouro);

		assertThat(endereco.getLogradouro(), equalTo(logradouro));
	}

	@Test
	public void deveCadastrarNumeroCorretamente() {

		Integer numero = 2763;

		endereco.setNumero(numero);

		assertThat(endereco.getNumero(), equalTo(numero));
	}

	@Test
	public void deveCadastrarComplementoCorretamente() {

		String complemento = "Apto 302, Bloco 2";
		endereco.setComplemento(complemento);
		assertThat(endereco.getComplemento(), equalTo(complemento));
	}

	@Test
	public void deveCadastrarBairroCorretamente() {

		String bairro = "Paralelepipedo";

		endereco.setBairro(bairro);

		assertThat(endereco.getBairro(), equalTo(bairro));
	}

	@Test
	public void deveCadastrarCidadeCorretamente() {

		String cidade = "São Paulo";

		endereco.setCidade(cidade);
		assertThat(endereco.getCidade(), equalTo(cidade));
	}

	@Test
	public void deveCadastrarEstadoCorretamente() {

		String estado = "São Paulo";

		endereco.setEstado(estado);
		assertThat(endereco.getEstado(), equalTo(estado));
	}

	@Test
	public void deveCadastrarPaisCorretamente() {

		String pais = "Brasil";

		endereco.setPais(pais);
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
		Endereco endereco = new Endereco("Rua Vergueiro", 18,
				"", "Sanola", "São Paulo", "SP", "11111-111",
				"Brasil");
		String formatado = "Rua Vergueiro, 18 - Bairro Sanola - "
				+ "11111-111 - São Paulo, SP - Brasil";

		assertThat(endereco.formatado(), equalTo(formatado));
	}
}