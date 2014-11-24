package br.com.gameshunter.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Converte dados para Hash
 * 
 * @author Myho
 */
public class HashFactory {

	/**
	 * Gera Hash em Sha-512
	 * 
	 * @return hash gerada
	 */
	public static String sha512(String string) {
		return DigestUtils.sha512Hex(string);
	}

	/**
	 * Gera Hash em Sha-384
	 * 
	 * @return hash gerada
	 */
	public static String sha384(String string) {
		return DigestUtils.sha384Hex(string);
	}

	/**
	 * Gera Hash em Sha-256
	 * 
	 * @return hash gerada
	 */
	public static String sha256(String string) {
		return DigestUtils.sha256Hex(string);
	}

	/**
	 * Gera Hash em md5
	 * 
	 * @return hash gerada
	 */
	public static String md5(String string) {
		return DigestUtils.md5Hex(string);
	}
}