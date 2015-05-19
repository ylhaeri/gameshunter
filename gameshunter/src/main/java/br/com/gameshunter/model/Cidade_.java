package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.226-0300")
@StaticMetamodel(Cidade.class)
public class Cidade_ {
	public static volatile SingularAttribute<Cidade, Integer> id;
	public static volatile SingularAttribute<Cidade, String> nome;
	public static volatile SingularAttribute<Cidade, Estado> estado;
	public static volatile SingularAttribute<Cidade, String> cep;
}
