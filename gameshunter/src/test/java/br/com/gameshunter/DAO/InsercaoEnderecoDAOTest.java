package br.com.gameshunter.DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.apache.struts2.views.jsp.ui.FormTag;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;

public class InsercaoEnderecoDAOTest {

	private static EntityManager manager;
	private final static String txtCidade = "Cidade.txt";
	private final static String txtEstado = "Estado.txt";
	private final static String txtPais = "Pais.txt";
	private static CidadeDAO cDao;
	private EstadoDAO eDao;
	private PaisDAO pDao;
	private List<Pais> paises;
	private List<Estado> estados;
	private List<Cidade> cidades;

	@BeforeClass
	public static void globalSetUp() throws IOException {
		new JPAUtil();
		manager = new JPAUtil().getEntityManager();
		new InsercaoEnderecoDAOTest().carregaDados();
	}

	@Before
	public void inicia() {
		cDao = new CidadeDAO(manager);
		eDao = new EstadoDAO(manager);
		pDao = new PaisDAO(manager);
		manager.getTransaction().begin();
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();
		manager.close();
	}

	@Test
	public void pegaPaises(){
		
		List<Pais> paises = pDao.pegaTodos();
		
		System.out.println(paises);
		
		assertThat(2, equalTo(paises.size()));
	}

	public Cidade formataCidade(String s) {

		Cidade cidade = new Cidade();
		StringBuilder builder = new StringBuilder();

		for (int i = 0, j = 1; s.length() > i; i++) {

			if (s.charAt(i) != '(') {

				if (s.charAt(i) != ')') {

					if (s.charAt(i) == '\'')
						i++;

					if (s.charAt(i) == ',' || s.charAt(i) == ';') {

						if (s.charAt(i++) == ' ')
							i++;

						if (j == 1)
							builder.delete(0, builder.length());
						else if (j == 2) {
							cidade.setNome(builder.toString());
							builder.delete(0, builder.length());
						}

						j++;
						continue;
					}

					builder.append(s.charAt(i));

				}
			}
		}

		return cidade;
	}

	public Estado formataEstado(String s) {

		Estado estado = new Estado();
		StringBuilder builder = new StringBuilder();

		for (int i = 0, j = 1; s.length() > i; i++) {

			if (s.charAt(i) != '(') {

				if (s.charAt(i) != ')') {

					if (s.charAt(i) == '\'')
						i++;

					if (s.charAt(i) == ',' || s.charAt(i) == ';') {

						if (s.charAt(i++) == ' ')
							i++;

						if (j == 1)
							builder.delete(0, builder.length());
						else if (j == 2) {
							estado.setNome(builder.toString());
							builder.delete(0, builder.length());
						} else if (j == 3) {
							estado.setUf(builder.toString());
							builder.delete(0, builder.length());
						}

						j++;
						continue;
					}

					builder.append(s.charAt(i));

				}
			}
		}

		return estado;
	}

	public Pais formataPais(String s) {

		Pais pais = new Pais();
		StringBuilder builder = new StringBuilder();

		for (int i = 0, j = 1; s.length() > i; i++) {

			if (s.charAt(i) != '(') {

				if (s.charAt(i) != ')') {

					if (s.charAt(i) == '\'')
						i++;
					if (s.charAt(i) == ')')
						i++;

					if (s.charAt(i) == ',' || s.charAt(i) == ';') {

						if (s.charAt(i++) == ' ')
							i++;

						if (j == 1)
							builder.delete(0, builder.length());
						else if (j == 2) {
							pais.setNome(builder.toString());
							builder.delete(0, builder.length());
						} else if (j == 3) {
							pais.setSigla(builder.toString());
							builder.delete(0, builder.length());
						}

						j++;
						continue;
					}

					builder.append(s.charAt(i));

				}
			}
		}

		return pais;
	}

	public void carregaDados() throws IOException {

		InputStream is = new FileInputStream(txtPais);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String resultado = br.readLine();

		while (resultado != null) {
			Pais pais = new InsercaoEnderecoDAOTest().formataPais(resultado);
			manager.persist(pais);
			resultado = br.readLine();
		}
		
	}

}
