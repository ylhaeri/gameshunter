package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.226-0300")
@StaticMetamodel(Estado.class)
public class Estado_ {
	public static volatile SingularAttribute<Estado, Integer> id;
	public static volatile SingularAttribute<Estado, String> nome;
	public static volatile SingularAttribute<Estado, String> uf;
	public static volatile SingularAttribute<Estado, Pais> pais;
}
