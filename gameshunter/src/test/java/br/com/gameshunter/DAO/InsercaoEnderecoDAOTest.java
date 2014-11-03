package br.com.gameshunter.DAO;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.util.Arquivo;

public class InsercaoEnderecoDAOTest {

	private static EntityManager manager;
	private final static String txtCidade = "Cidade.txt";
	private final static String txtEstado = "Estado.txt";
	private final static String txtPais = "Pais.txt";
	private static CidadeDAO cDao;
	private EstadoDAO eDao;
	private PaisDAO pDao;
	private static Integer cod_estado;

	@BeforeClass
	public static void globalSetUp() throws IOException {

		new JPAUtil();
		manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		for (Pais pais : new Arquivo().lerPais()) {
			manager.persist(pais);
		}

		manager.getTransaction().commit();

		manager.getTransaction().begin();

		for (Estado estado : new Arquivo().lerEstado()) {
			estado.setPais(manager.find(Pais.class, 1));
			manager.persist(estado);
		}

		manager.getTransaction().commit();

		manager.getTransaction().begin();

		for (Cidade cidade : new Arquivo().lerCidade()) {
			cidade.setEstado(manager.find(Estado.class, 1));
			manager.persist(cidade);
		}

		manager.getTransaction().commit();
		
		manager.close();

	}

	@Before
	public void inicia() {
		manager = new JPAUtil().getEntityManager();
		cDao = new CidadeDAO(manager);
		eDao = new EstadoDAO(manager);
		pDao = new PaisDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
	}

	@Test
	public void pegaPaises() {

		List<Pais> paises = pDao.pegaTodos();

		System.out.println(paises);
		
		assertThat(paises.size(), equalTo(1));
	}

	@Test
	public void pegaEstado() {

		List<Estado> estados = eDao.pegaTodos(pDao.pega(1));
		
		System.out.println(estados);
		
		assertThat(estados.size(), equalTo(27));
	}

	@Test
	public void devePegarTodasAsCidades() {

		List<Cidade> cidades = cDao.pegaTodos(manager.find(Estado.class, 1));
		assertThat(cidades.size(), equalTo(5564));
	}

}
