//package br.com.gameshunter.model;
//
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.hasItems;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Test;
//
//public class SexoTest {
//
//	@Test
//	public void deveConterOsGenerosNecessarios() {
//		Gender fem = Gender.Feminino;
//		Gender masc = Gender.Masculino;
//		Gender indef = Gender.Indefinido;
//
//		List<Gender> lista = Arrays.asList(Gender.values());
//
//		assertThat(lista, hasItems(fem, masc, indef));
//		assertNotNull(Gender.valueOf("Feminino"));
//	}
//}