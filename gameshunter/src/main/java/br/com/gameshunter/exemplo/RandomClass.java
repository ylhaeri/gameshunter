package br.com.gameshunter.exemplo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

/**
 * @author Gabriel
 *
 */
@Entity
public class RandomClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Retorna o nome da música mais legal que já inventaram. Esse é um fato
	 * indiscutível.
	 * 
	 * @return o nome de uma música.
	 */
	public String testeJavaDoc() {

		return "sou foda";
	}
	
	
	/**
	 *Método que não faz nada, só testa o javadoc
	 *
	 * @return retorna nada
	 */
	public void arara() {
		
		return;
	}
	// Exemplo básico de hibernate pra poder entender mais ou menos :x

	public static void main(String[] args) {

		RandomClass rc = new RandomClass();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("gameshunter");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(rc);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}