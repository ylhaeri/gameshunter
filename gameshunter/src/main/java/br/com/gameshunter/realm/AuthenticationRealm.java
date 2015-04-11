package br.com.gameshunter.realm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gameshunter.model.User;
import br.com.gameshunter.service.UserService;

public class AuthenticationRealm extends AuthorizingRealm {

	@Autowired
	UserService service;
	private static final transient Logger log = LoggerFactory
			.getLogger(AuthenticationRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Set<String> roles = new HashSet<String>();
		Set<Permission> permissions = new HashSet<Permission>();
		Collection<User> principalsList = principals.byType(User.class);

		if (principalsList.isEmpty()) {
			throw new AuthorizationException("Empty principals list!");
		}

		roles.add("admin");
		permissions.add(new WildcardPermission("teste"));

		// THIS IS THE MAIN CODE YOU NEED TO DO !!!!
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setObjectPermissions(permissions);

		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		User user = service.find(upToken.getUsername());

		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		DefaultPasswordService passwordService = new DefaultPasswordService();
		DefaultHashService hashService = new DefaultHashService();
		hashService.setHashAlgorithmName(Sha512Hash.ALGORITHM_NAME);
		hashService.setHashIterations(500000);
		hashService.setGeneratePublicSalt(true);
		hashService.setPrivateSalt(new SimpleByteSource(":3M9@%U)#=Sz3~)PCBlYgnOt"));
		passwordService.setHashService(hashService);
		
		System.out.println(passwordService.encryptPassword("2517868"));

//		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
//				"classpath:shiro.ini");
//		SecurityManager securityManager = factory.getInstance();
//		SecurityUtils.setSecurityManager(securityManager);
//
//		UsernamePasswordToken token = new UsernamePasswordToken(
//				"gabriel.haeri@gmail.com", "2517868");
//		token.setRememberMe(true);
//
//		Subject user = SecurityUtils.getSubject();
//
//		user.login(token);
		//
		// System.out.println("Autenticado: " + user.isAuthenticated());
		//
		// System.out.println("Tem role admin: " + user.hasRole("admin"));
		// System.out.println("Tem role domo: " + user.hasRole("domo"));
		//
		// System.out.println("Tem permissão de cadastrar novo produto: "
		// + user.isPermitted("produto:novo"));
	}
}
