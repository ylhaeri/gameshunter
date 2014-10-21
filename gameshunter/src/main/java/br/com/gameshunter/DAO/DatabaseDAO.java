package br.com.gameshunter.DAO;

public interface DatabaseDAO<t> {

	/**
	 * @return Arara
	 */
	public Long conta();

	public void salva(Object objeto);

	public <T>t pega(Object chavePrimaria);

	public void remove(Object objeto);
}