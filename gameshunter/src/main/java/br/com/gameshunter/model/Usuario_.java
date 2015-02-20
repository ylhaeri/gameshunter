package br.com.gameshunter.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-20T09:11:20.533-0200")
@StaticMetamodel(Usuario.class)
public class Usuario_ {
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, String> apelido;
	public static volatile SingularAttribute<Usuario, Sexo> sexo;
	public static volatile SingularAttribute<Usuario, String> cpf;
	public static volatile SingularAttribute<Usuario, LocalDate> dataNascimento;
	public static volatile SingularAttribute<Usuario, String> telefone;
	public static volatile SingularAttribute<Usuario, String> celular;
	public static volatile ListAttribute<Usuario, Endereco> enderecos;
	public static volatile SingularAttribute<Usuario, String> senha;
}
