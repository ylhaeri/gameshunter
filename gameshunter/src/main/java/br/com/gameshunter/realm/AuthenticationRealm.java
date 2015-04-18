package br.com.gameshunter.realm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gameshunter.model.User;
import br.com.gameshunter.service.UserService;

public class AuthenticationRealm extends AuthorizingRealm {

	@Autowired
	UserService service;

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
}