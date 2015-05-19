package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.126-0300")
@StaticMetamodel(Address.class)
public class Address_ {
	public static volatile SingularAttribute<Address, Integer> id;
	public static volatile SingularAttribute<Address, Logradouro> logradouro;
	public static volatile SingularAttribute<Address, Integer> numero;
	public static volatile SingularAttribute<Address, String> complemento;
}
