package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.226-0300")
@StaticMetamodel(Logradouro.class)
public class Logradouro_ {
	public static volatile SingularAttribute<Logradouro, Integer> id;
	public static volatile SingularAttribute<Logradouro, String> nome;
	public static volatile SingularAttribute<Logradouro, Bairro> bairro;
	public static volatile SingularAttribute<Logradouro, String> tipo;
	public static volatile SingularAttribute<Logradouro, String> cep;
	public static volatile SingularAttribute<Logradouro, String> logradouro;
}