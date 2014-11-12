package br.com.gameshunter.main;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.gameshunter.DAO.CidadeDAO;
import br.com.gameshunter.DAO.EstadoDAO;
import br.com.gameshunter.DAO.JPAUtil;
import br.com.gameshunter.DAO.PaisDAO;
import br.com.gameshunter.model.Cidade;
import br.com.gameshunter.model.Estado;
import br.com.gameshunter.model.Pais;
import br.com.gameshunter.system.Arquivo;
import br.com.gameshunter.util.EscritorXML;

public class CriaXMLCidadePaisEstado {

	public static void criaArquivos() {
		File arqPais = Arquivo.noDiretorioPadrao("\\xml\\paises.xml");
		File arqEstado = Arquivo.noDiretorioPadrao("\\xml\\estados.xml");
		File arqCidade = Arquivo.noDiretorioPadrao("\\xml\\cidades.xml");

		if (!arqPais.exists() || !arqEstado.exists() || !arqCidade.exists()) {
			EntityManager manager = JPAUtil.getEntityManager();

			if (!arqPais.exists()) {
				List<Pais> paises = new PaisDAO(manager).pegaTodos();
				new EscritorXML(arqPais).comAlias("país", Pais.class)
						.omitindoCampo(Pais.class, "id").from(paises).salva();
			}
			if (!arqEstado.exists()) {
				List<Estado> estados = new EstadoDAO(manager).pegaTodos();
				new EscritorXML(arqEstado).comAlias("estado", Estado.class)
						.omitindoCampo(Estado.class, "id").from(estados)
						.salva();
			}
			if (!arqCidade.exists()) {
				List<Cidade> cidades = new CidadeDAO(manager).pegaTodos();
				new EscritorXML(arqCidade).comAlias("cidade", Cidade.class)
						.omitindoCampo(Cidade.class, "id").from(cidades)
						.salva();
			}
			manager.close();
		}
	}
}