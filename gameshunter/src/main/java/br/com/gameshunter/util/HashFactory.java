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
	public String geraHashedString(String string) {
		return processaHash(string, "SHA-256");
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