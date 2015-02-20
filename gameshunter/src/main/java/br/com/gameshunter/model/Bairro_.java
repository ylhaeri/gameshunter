package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-20T09:11:20.432-0200")
@StaticMetamodel(Bairro.class)
public class Bairro_ {
	public static volatile SingularAttribute<Bairro, Integer> id;
	public static volatile SingularAttribute<Bairro, String> nome;
	public static volatile SingularAttribute<Bairro, Cidade> cidade;
}
