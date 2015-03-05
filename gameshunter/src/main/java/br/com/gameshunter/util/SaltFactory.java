package br.com.gameshunter.util;

import org.apache.commons.lang3.RandomStringUtils;

public class SaltFactory {

	public static String generateSalt() {

		return RandomStringUtils.randomAscii(20);
	}
}