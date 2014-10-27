package br.com.gameshunter.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SexoTest {

	@Test
	public void deveConterOsGenerosNecessarios() {
		Sexo fem = Sexo.Feminino;
		Sexo masc = Sexo.Masculino;
		Sexo indef = Sexo.Indefinido;

		List<Sexo> lista = Arrays.asList(Sexo.values());

		assertThat(lista, hasItems(fem, masc, indef));
		assertNotNull(Sexo.valueOf("Feminino"));
	}
}