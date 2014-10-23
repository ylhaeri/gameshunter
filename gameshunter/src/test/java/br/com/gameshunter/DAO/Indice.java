package br.com.gameshunter.DAO;

public class Indice {
	private static Integer endereco = 0;

	public static void contaEndereco() {
		endereco++;
	}

	public static Integer pegaEndereco() {
		return endereco;
	}
}