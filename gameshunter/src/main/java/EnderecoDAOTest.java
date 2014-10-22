import javax.persistence.EntityManager;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.DAO.EnderecoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.model.Endereco;
import br.com.gameshunter.model.Endereco;

public class EnderecoDAOTest {

	private EntityManager manager;
	private static EnderecoDAO eDao;
	private Endereco endereco;
	private int i = 0;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		eDao = new EnderecoDAO();
	}

	@Before
	public void inicia() {
		manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		endereco = new Endereco();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@AfterClass
	public static void encerra() {
		JPAUtil.closeFactory();
	}

	@Test
	public void adicionaUmEndereco() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua paranaue");
		endereco.setNumero(123);
		endereco.setBairro("Parque Br");
		endereco.setCidade("São Paulo");
		endereco.setEstado("SP");
		endereco.setCep("31456892");
		endereco.setComplemento("Conj B");
		endereco.setPais("Brasil");

		salva(endereco);

		Endereco esperado = pega(i);

		assertThat(endereco, equalTo(esperado));

	}

	@Test
	public void atualizaEndereco() {

		String enderecoReal = "Meia lua";
		String enderecoAtualizado = "Nova lua";

		endereco.setBairro(enderecoReal);

		salva(endereco);

		endereco.setBairro(enderecoAtualizado);

		atualiza(endereco);

		Endereco novo = new Endereco();

		novo.setBairro(enderecoAtualizado);

		Endereco esperado = pega(i);

		System.out.println(esperado.getBairro());

		assertThat(novo.getBairro(), equalTo(esperado.getBairro()));

	}

	@Test
	public void removeEndereco() {
		endereco.setCidade("Osasco");

		salva(endereco);
	}

	private void salva(Endereco end) {
		eDao.salva(manager, end);
		i++;
	}

	private void remove(Endereco end) {
		eDao.remove(manager, end);
	}

	private Long conta() {
		return eDao.conta(manager);
	}

	private void atualiza(Endereco end) {
		eDao.atualiza(manager, end);
	}

	private Endereco pega(Integer id) {
		return eDao.pega(manager, id);
	}
}
