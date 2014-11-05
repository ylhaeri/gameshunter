package br.com.gameshunter.action;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Teste {

	public static void main(String[] args) throws ParseException {

		String testeData = "16/04/1993";
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		TemporalAccessor temporal = fmt.parse(testeData);
		LocalDate data = LocalDate.from(temporal);
		System.out.println(data);
	}
}