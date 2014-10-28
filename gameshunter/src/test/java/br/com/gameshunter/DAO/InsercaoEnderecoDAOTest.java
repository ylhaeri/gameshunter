package br.com.gameshunter.DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private static String infoCidade;
	private static String infoEstado;
	private static String infoPais;
	private static CidadeDAO cDao;
	private EstadoDAO eDao;
	private PaisDAO pDao;
	private static Integer cod_estado;

	@BeforeClass
	public static void globalSetUp() throws IOException {
		new JPAUtil();
		manager = new JPAUtil().getEntityManager();
		new InsercaoEnderecoDAOTest().carregaDados();
	}

	@Before
	public void inicia() {
		manager.getTransaction().begin();
		cDao = new CidadeDAO(manager);
		eDao = new EstadoDAO(manager);
		pDao = new PaisDAO(manager);
	}

	@After
	public void finaliza() {
		manager.getTransaction().rollback();

	}

	@Test
	public void pegaPaises() {

		List<Pais> paises = pDao.pegaTodos();

		assertThat(paises.size(), equalTo(2));

	}

	@Test
	public void pegaEstado() {

		List<Estado> estados = eDao.pegaTodos(manager.find(Pais.class, 1));

		assertThat(estados.size(), equalTo(27));
	}

	private Cidade formataCidade(String s) {

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
						} else if (j == 3) {
							cod_estado = Integer.parseInt(builder.toString());

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

	private Estado formataEstado(String s) {

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

	private Pais formataPais(String s) {

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

	private void carregaDados() throws IOException {

		EntityManager manager = new JPAUtil().getEntityManager();

		BufferedReader br = new InsercaoEnderecoDAOTest()
				.carregaArquivo(txtPais);
		String paises = br.readLine();

		manager.getTransaction().begin();

		while (paises != null) {
			Pais pais = new InsercaoEnderecoDAOTest().formataPais(paises);

			manager.persist(pais);

			paises = br.readLine();
		}

		manager.getTransaction().commit();

		br.close();

		manager.getTransaction().begin();

		br = new InsercaoEnderecoDAOTest().carregaArquivo(txtEstado);
		String estados = br.readLine();

		while (estados != null) {
			Estado estado = new InsercaoEnderecoDAOTest()
					.formataEstado(estados);
			estado.setPais(manager.find(Pais.class, 1));

			manager.persist(estado);

			estados = br.readLine();
		}

		manager.getTransaction().commit();

		br.close();

		manager.getTransaction().begin();

		br = new InsercaoEnderecoDAOTest().carregaArquivo(txtCidade);
		String cidades = br.readLine();

		while (cidades != null) {
			Cidade cidade = new InsercaoEnderecoDAOTest()
					.formataCidade(cidades);
			cidade.setEstado(manager.find(Estado.class, cod_estado));
			manager.persist(cidade);
			cidades = br.readLine();
		}

		manager.getTransaction().commit();

		br.close();

	}

	private BufferedReader carregaArquivo(String informacao) throws IOException {
		InputStream is = new FileInputStream(informacao);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

}
