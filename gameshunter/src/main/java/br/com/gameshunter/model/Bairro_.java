package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.226-0300")
@StaticMetamodel(Bairro.class)
public class Bairro_ {
	public static volatile SingularAttribute<Bairro, Integer> id;
	public static volatile SingularAttribute<Bairro, String> nome;
	public static volatile SingularAttribute<Bairro, Cidade> cidade;
}
