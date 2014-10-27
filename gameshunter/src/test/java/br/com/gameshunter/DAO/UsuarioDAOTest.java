package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.factory.EnderecoFactory;
import br.com.gameshunter.factory.UsuarioFactory;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Sexo;
import br.com.gameshunter.model.Usuario;

public class UsuarioDAOTest {

	private final String email = "joao@gmail.com";
	private Usuario joao;
	private EntityManager manager;
	private List<Endereco> enderecos;
	private static UsuarioDAO uDao;
	private static EnderecoDAO eDao;
	private static UsuarioFactory uFac;
	private static EnderecoFactory eFac;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		uFac = new UsuarioFactory();
		eFac = new EnderecoFactory();
	}

	@Before
	public void inicia() {
		joao = uFac.comEmailSemEndereco(email);
		enderecos = joao.getEnderecos();
		manager = new JPAUtil().getEntityManager();
		uDao = new UsuarioDAO(manager);
		eDao = new EnderecoDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void tabelaUsuarioDeveCadastrarONumeroCorretoDeUsuarios() {

		uDao.salva(joao);

		Long contagem = uDao.conta();

		assertThat(contagem, equalTo(1l));
	}

	@Test
	public void deveConterUsuarioComCamposCorretos() {

		Usuario joao = new Usuario();
		String nome = "João da Silva Machado";
		String apelido = "Pikachu Iluminado";
		Sexo sexo = Sexo.Masculino;
		String senha = "aranhaBolao";
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(1990, 1, 12, 12, 0, 0);
		String email = "joao@gmail.com";
		String telefone = "(11) 1111-1111";
		String cpf = "000.000.000-00";
		String rg = "1234567-890";
		Endereco endereco = eFac.repetido();

		joao.setNome(nome);
		joao.setApelido(apelido);
		joao.setSexo(sexo);
		joao.setSenha(senha);
		joao.setDataNascimento(dataNascimento);
		joao.setEmail(email);
		joao.setTelefone(telefone);
		joao.setCpf(cpf);
		joao.setRg(rg);
		joao.adicionaEndereco(endereco);

		uDao.salva(joao);
		salva(endereco);

		Usuario joana = uDao.pega(email);
		Long uContagem = uDao.conta();
		Long eContagem = eDao.conta();

		assertThat(uContagem, equalTo(1l));
		assertThat(eContagem, equalTo(1l));
		assertThat(joana.getNome(), equalTo(nome));
		assertThat(joana.getApelido(), equalTo(apelido));
		assertThat(joana.getSexo(), equalTo(sexo));
		assertThat(joana.getSenha(), equalTo(senha));
		assertThat(joana.getDataNascimento().getTime(),
				equalTo(dataNascimento.getTime()));
		assertThat(joana.getEmail(), equalTo(email));
		assertThat(joana.getTelefone(), equalTo(telefone));
		assertThat(joana.getCpf(), equalTo(cpf));
		assertThat(joana.getRg(), equalTo(rg));
		assertThat(joana.pegaEndereco(0), equalTo(endereco));
	}

	@Test
	public void deveAtualizarUsuariosDoBanco() {

		String nome = "Dedinho Osvaldo";
		String nAlterado = "Osvaldo Patricio";

		joao.setNome(nome);
		uDao.salva(joao);

		joao = uDao.pega(email);
		joao.setNome(nAlterado);
		uDao.atualiza(joao);

		joao = uDao.pega(email);
		Long contagem = uDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(joao.getNome(), equalTo(nAlterado));
	}

	@Test
	public void deveRemoverUsuarioDoBanco() {

		uDao.salva(joao);
		uDao.remove(joao);

		joao = uDao.pega(email);
		Long contagem = uDao.conta();

		assertThat(contagem, equalTo(0l));
		assertNull(joao);
	}

	@Test
	public void deveEncontrarEnderecoAtravesDoUsuario() {

		Endereco endereco = eFac.repetido();

		joao.adicionaEndereco(endereco);

		salva(endereco);
		uDao.salva(joao);

		Long uContagem = uDao.conta();
		Long eContagem = eDao.conta();

		Usuario joana = uDao.pega(email);
		Endereco enderecoDaJoana = joana.pegaEndereco(0);

		assertThat(eContagem, equalTo(1l));
		assertThat(uContagem, equalTo(1l));
		assertThat(enderecoDaJoana, equalTo(endereco));
	}

	@Test
	public void deveConterUsuarioComVariosEnderecos() {

		Endereco endereco1 = eFac.comLogradouro("Rua Vergueiro");
		Endereco endereco2 = eFac.comLogradouro("Avenida Tupabaram");
		Endereco endereco3 = eFac.comLogradouro("Rua Tamborim");

		joao.adicionaEndereco(endereco1);
		joao.adicionaEndereco(endereco2);
		joao.adicionaEndereco(endereco3);

		salva(endereco1);
		salva(endereco2);
		salva(endereco3);
		uDao.salva(joao);

		joao = uDao.pega(email);

		Long uContagem = uDao.conta();
		Long eContagem = eDao.conta();

		assertThat(uContagem, equalTo(1l));
		assertThat(eContagem, equalTo(3l));
		assertThat(enderecos.size(), equalTo(3));
		assertThat(enderecos, hasItems(endereco1, endereco2, endereco3));
	}

	@Test
	public void deveConterVariosUsuariosComOMesmoEndereco() {

		Endereco endereco1 = eFac.repetido();
		Endereco endereco2 = eFac.repetido();
		Endereco endereco3 = eFac.repetido();

		Usuario ronaldo = uFac.comEmailSemEndereco("ronaldo@gmail.com");
		Usuario jamelao = uFac
				.comEmailSemEndereco("jamelao.osvaldo@hotmail.com");

		joao.adicionaEndereco(endereco1);
		ronaldo.adicionaEndereco(endereco2);
		jamelao.adicionaEndereco(endereco3);

		uDao.salva(joao);
		uDao.salva(ronaldo);
		uDao.salva(jamelao);
		salva(endereco1);
		salva(endereco2);
		salva(endereco3);

		Long contagemU = uDao.conta();
		Long contagemE = eDao.conta();

		assertThat(contagemU, equalTo(3l));
		assertThat(contagemE, equalTo(3l));
		assertThat(joao.getEnderecos(), hasItem(endereco1));
		assertThat(ronaldo.getEnderecos(), hasItem(endereco2));
		assertThat(jamelao.getEnderecos(), hasItem(endereco3));
	}

	@Test
	public void deveAlterarEnderecoDoUsuario() {

		Endereco endereco = eFac.comLogradouro("Rua Chalompa");

		joao.adicionaEndereco(endereco);

		salva(endereco);
		uDao.salva(joao);

		Usuario joana = uDao.pega(email);
		joana.pegaEndereco(0)
				.setLogradouro("Bairro da Joana do coraçãozinhos2");

		uDao.atualiza(joana);

		joao = uDao.pega(email);

		Endereco enderedoAtualizado = eFac
				.comLogradouro("Bairro da Joana do coraçãozinhos2");
		Long contagem = eDao.conta();

		assertThat(contagem, equalTo(1l));
		assertThat(enderecos.size(), equalTo(1));
		assertThat(enderecos, hasItem(enderedoAtualizado));
	}

	@Test
	public void deveRemoverEnderecoJuntoDoUsuario() {

		joao = uFac.comEmailEEnderecos("renatinho@hotmail.com");

		enderecos = joao.getEnderecos();

		enderecos.forEach(e -> salva(e));
		uDao.salva(joao);

		uDao.remove(joao);

		Long uContagem = uDao.conta();
		Long eContagem = eDao.conta();

		assertThat(uContagem, equalTo(0l));
		assertThat(eContagem, equalTo(0l));
		assertThat(enderecos.size(), equalTo(3));
	}

	@Test
	public void deveRemoverUsuarioSemEndereco() {
		Usuario usuario = uFac.comEmailSemEndereco(email);
		uDao.salva(usuario);

		usuario = uDao.pega(email);
		uDao.remove(usuario);

		Long uContagem = uDao.conta();

		assertThat(uContagem, equalTo(0l));
	}

	@Test
	public void deveSaberIniciarTransactionECommitarCorretamente() {

		this.manager.close();
		manager = new JPAUtil().getEntityManager();

		uDao = new UsuarioDAO(manager);

		uDao.iniciaTransaction().salva(joao).commit().close();

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		uDao = new UsuarioDAO(manager);

		Long contagem1 = uDao.conta();
		joao = uDao.pega(email);
		uDao.remove(joao).commit().close();

		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		uDao = new UsuarioDAO(manager);

		Long contagem2 = uDao.conta();

		assertThat(contagem1, equalTo(1l));
		assertThat(contagem2, equalTo(0l));
	}

	private void salva(Endereco endereco) {
		eDao.salva(endereco);
		Indice.contaEndereco();
		manager.persist(endereco.getPais());
		manager.persist(endereco.getEstado());
		manager.persist(endereco.getCidade());
	}
}