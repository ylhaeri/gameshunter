package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-20T09:11:20.529-0200")
@StaticMetamodel(Estado.class)
public class Estado_ {
	public static volatile SingularAttribute<Estado, Integer> id;
	public static volatile SingularAttribute<Estado, String> nome;
	public static volatile SingularAttribute<Estado, String> uf;
	public static volatile SingularAttribute<Estado, Pais> pais;
}
