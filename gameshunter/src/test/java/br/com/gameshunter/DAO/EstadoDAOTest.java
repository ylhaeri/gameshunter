package br.com.gameshunter.DAO;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EstadoDAOTest {

	private EntityManager manager;
	private List<Estado> estados;
	private EstadoDAO eDAO;
	private Pais pais;
	
	@BeforeClass
	public static void globalSetUp() {
		new JPAUtil();	
	}
	
	@Before
	public void inicia() {
		manager = new JPAUtil().getEntityManager();
		this.eDAO = new EstadoDAO(manager);
		manager.getTransaction().begin();
		pais = manager.find(Pais.class, 1);
	}
	
	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		eDAO.fechaConexao();
	}
	
	@Test
	public void pegaTodosEstadosDeUmPais() {
		estados = eDAO.pega(pais);
		assertThat(27, equalTo(estados.size()));
		
	}
	
	public void populaBanco(){
		
	}

}
