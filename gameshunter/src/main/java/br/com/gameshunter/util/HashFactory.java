package br.com.gameshunter.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Converte dados para Hash
 * 
 * @author Myho
 */
public class HashFactory {

	/**
	 * Gera hash da String solicitada
	 * 
	 * @return hash da String
	 */
	public String hashStringCodified(String string) {
		return processaHash(string, "SHA-512");
	}

	public String hashStringUncodified(String string) {
		return processaHash(string, "SHA-384");
	}

	public static void main(String[] args) {
		String string = new HashFactory()
				.hashStringCodified("Gabriel Diniz Oliveira gabriel.dinizo@hotmail.com");
		System.out.println("Começou");
		int iguais = 0;
		int diferentes = 0;
		System.out.println(string);
		for (int i = 0; i < 1000000000; i++) {

			if (!string
					.equals("a9eb65c9537a1e5e4d925a0e98d9c2d73422a9147917ed947c133bfd95215722")) {

				diferentes++;
			} else {
				iguais++;
			}
		}
		System.out.println("Iguais: " + iguais + "\nDiferentes: " + diferentes);
	}

	/**
	 * Cria o hash codificado da String solicitada
	 * 
	 * @param string
	 *            string que deve ser ser criptografada
	 * @return string criptografada
	 */
	private String processaHash(String string, String algoritimo) {
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance(algoritimo);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		digester.update(string.getBytes());
		byte[] hash = digester.digest();
		return codifica(hash);
	}

	/**
	 * Cria a codificação para os bytes de uma hash
	 * 
	 * @param hash
	 *            bytes que defem ser codificados.
	 * 
	 * @return string codificada.
	 */
	private String codifica(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}
}