package br.com.gameshunter.DAO;

public interface BasicDbDAO {

	/**
	 * Inicia a transação com o banco de dados. Deve ser usado para que a
	 * iteração pode ser feita.
	 * 
	 * @return Ele mesmo.
	 */
	public BasicDbDAO iniciaTransaction();

	/**
	 * Faz o commit do que foi efetuado na transação com o banco de dados. Deve
	 * ser usado para que os dados sejam gravados no banco de dados.
	 * 
	 * @return Ele mesmo.
	 */
	public BasicDbDAO commit();

	/**
	 * Faz o fechamento do manager, deve ser usado ao final de qualquer
	 * transação com o DAO.
	 */
	public void close();

	/**
	 * Retorna a quantidade de objetos existentes na tabela do banco.
	 * 
	 * @return Quantidade de objetos da tabela.
	 */
	public Long conta();
}