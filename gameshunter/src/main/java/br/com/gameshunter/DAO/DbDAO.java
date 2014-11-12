package br.com.gameshunter.DAO;

public interface DbDAO<T, PK> extends BasicDbDAO {

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
	 * Salva um objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que deve ser salvo.
	 * 
	 * @return Ele mesmo.
	 */
	public BasicDbDAO salva(T objeto);

	/**
	 * Atualiza os dados do objeto no banco de dados.
	 * 
	 * @param objeto
	 *            Objeto que será atualizado.
	 * 
	 * @return Ele mesmo.
	 */
	public BasicDbDAO atualiza(T objeto);

	/**
	 * Remove o objeto desejado do banco.
	 * 
	 * @param objeto
	 *            Objeto que será removido.
	 * 
	 * @return Ele mesmo.
	 */
	public BasicDbDAO remove(T objeto);
}