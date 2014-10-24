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

	/**
	 * Inicia a transação com o banco de dados. Deve ser usado para que a
	 * iteração pode ser feita.
	 */
	public void iniciaTransaction();

	/**
	 * Faz o commit do que foi efetuado na transação com o banco de dados. Deve
	 * ser usado para que os dados sejam gravados no banco de dados.
	 */
	public void commit();
	
	/**
	 * Fecha a conexão criada
	 */
	public void fechaConexao();
}