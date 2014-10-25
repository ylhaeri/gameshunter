package br.com.gameshunter.DAO;

public interface DbDAO<T, PK> extends BasicDbDAO {

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
	public DbDAO<?, ?> salva(T objeto);

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
	public DbDAO<?, ?> remove(T objeto);

	/**
	 * Atualiza os dados do objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que será atualizado.
	 * 
	 * @return Ele mesmo.
	 */
	public DbDAO<?, ?> atualiza(T objeto);
}