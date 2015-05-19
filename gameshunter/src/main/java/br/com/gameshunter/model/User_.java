package br.com.gameshunter.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-05-15T03:11:32.226-0300")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> nickname;
	public static volatile SingularAttribute<User, Gender> gender;
	public static volatile SingularAttribute<User, String> cpf;
	public static volatile SingularAttribute<User, LocalDate> birthDay;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> mobile;
	public static volatile ListAttribute<User, Address> addresses;
	public static volatile SingularAttribute<User, Boolean> newsLetterEmail;
	public static volatile SingularAttribute<User, Boolean> agreeTermsOfService;
	public static volatile SingularAttribute<User, byte[]> profilePicture;
}
