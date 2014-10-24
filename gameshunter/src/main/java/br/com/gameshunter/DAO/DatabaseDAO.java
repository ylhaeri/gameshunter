package br.com.gameshunter.DAO;

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
	 * 
	 * @return Ele mesmo.
	 */
	public DatabaseDAO<?, ?> salva(T objeto);

	/**
	 * Pega o objeto desejado a partir de sua chave primária.
	 * 
	 * @param chavePrimaria
	 *            Chave primária da classe.
	 * 
	 * @return Objeto resgatado do banco.
	 */
	public T pega(PK chavePrimaria);

	/**
	 * Remove o objeto desejado do banco.
	 * 
	 * @param objeto
	 *            Objeto que será removido.
	 * 
	 * @return Ele mesmo.
	 */
	public DatabaseDAO<?, ?> remove(T objeto);

	/**
	 * Atualiza os dados do objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que será atualizado.
	 * 
	 * @return Ele mesmo.
	 */
	public DatabaseDAO<?, ?> atualiza(T objeto);

	/**
	 * Inicia a transação com o banco de dados. Deve ser usado para que a
	 * iteração pode ser feita.
	 * 
	 * @return Ele mesmo.
	 */
	public DatabaseDAO<?, ?> iniciaTransaction();

	/**
	 * Faz o commit do que foi efetuado na transação com o banco de dados. Deve
	 * ser usado para que os dados sejam gravados no banco de dados.
	 * 
	 * @return Ele mesmo.
	 */
	public DatabaseDAO<?, ?> commit();

	/**
	 * Faz o fechamento do manager, deve ser usado ao final de qualquer
	 * transação com o DAO.
	 */
	public void close();
}