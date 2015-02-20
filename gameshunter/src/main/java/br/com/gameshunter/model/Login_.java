package br.com.gameshunter.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-20T09:11:20.530-0200")
@StaticMetamodel(Login.class)
public class Login_ {
	public static volatile SingularAttribute<Login, Usuario> usuario;
	public static volatile SingularAttribute<Login, String> senha;
	public static volatile SingularAttribute<Login, String> salt;
	public static volatile SingularAttribute<Login, Boolean> confirmado;
}
