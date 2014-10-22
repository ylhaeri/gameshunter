package br.com.gameshunter.DAO;

import javax.persistence.EntityManager;

public interface DatabaseDAO<T, PK> {

	/**
	 * Retorna a quantidade de objetos existentes na tabela do banco.
	 * 
	 * @return Quantidade de objetos da tabela.
	 */
	public Long conta();

	/**
	 * Salva um objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que deve ser salvo.
	 */
	public void salva(T objeto);

	/**
	 * Pega o objeto desejado a partir de sua chave primária.
	 * 
	 * @param chavePrimaria
	 *            Chave primária da classe.
	 * @return Objeto resgatado do banco.
	 */
	public T pega(PK chavePrimaria);

	/**
	 * Remove o objeto desejado do banco.
	 * 
	 * @param objeto
	 *            Objeto que será removido.
	 */
	public void remove(T objeto);

	/**
	 * Atualiza os dados do objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que será atualizado.
	 * 
	 * @return Retorna a entidade removida
	 */
	public void atualiza(T objeto);

	/*
	 * 
	 * Métodos para classes de teste
	 */

	/**
	 * Usado para fazer a contagem em testes, deve ser usado somente para
	 * testes, não possui comportamento efetivo imediato.
	 * 
	 * @param manager
	 *            EntityManager que será usado.
	 * 
	 * @see conta();
	 */
	public Long conta(EntityManager manager);

	/**
	 * Usado para persistir o usuário no banco de dados. Deve ser usado somente
	 * para testes, não possui comportamento efetivo imediato.
	 * 
	 * @param manager
	 *            EntityManager que será usado.
	 * @param objeto
	 *            Objeto que será persistido.
	 * 
	 * @see salva(entidade);
	 */
	default public void salva(EntityManager manager, T objeto) {
		manager.persist(objeto);
	}

	/**
	 * Pega o objeto desejado a partir de sua chave primária.
	 *
	 * @param manager
	 * @param chavePrimaria
	 *            Chave primária da classe.
	 * 
	 * @return Objeto resgatado do banco.
	 */
	public T pega(EntityManager manager, PK privateKey);

	/**
	 * Usado para remover o usuário do banco de dados. Deve ser usado somente em
	 * ambiente de testes, não possui comportamento efetivo imediato.
	 * 
	 * @param manager
	 *            EntityManager que será usado.
	 * @param objeto
	 *            Objeto que será persistido.
	 * 
	 * @see remove(entidade);
	 */
	default public void remove(EntityManager manager, T objeto) {
		manager.merge(objeto);
		manager.remove(objeto);
	}

	/**
	 * Usado para atualizar o usuário do banco de dados. Deve ser usado somente
	 * em ambiente de testes, não possui comportamento efetivo imediato.
	 * 
	 * @param manager
	 *            Entitymanager que será usado.
	 * @param objeto
	 *            Objeto que será atualizado.
	 */
	default public void atualiza(EntityManager manager, T objeto) {
		manager.merge(objeto);
	}

}