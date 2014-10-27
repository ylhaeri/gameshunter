package br.com.gameshunter.DAO;

import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;

public class CidadeDAOTest {

	private EntityManager manager;
	private List<Cidade> cidades;
	private CidadeDAO cDAO;
	private Estado estado;

	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();
		
	}

	@Before
	public void inicia() {
		manager = new JPAUtil().getEntityManager();
		this.cDAO = new CidadeDAO(manager);
		manager.getTransaction().begin();
		estado = manager.find(Estado.class, 2);
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		cDAO.fechaConexao();
	}

	@Test
	public void pegaTodasCidadesDeUmEstado() {
		
		
		cidades = cDAO.pega(estado);
		assertThat(102, equalTo(cidades.size()));
	}

}
