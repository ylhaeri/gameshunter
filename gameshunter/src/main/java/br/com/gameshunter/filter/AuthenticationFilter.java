package br.com.gameshunter.filter;

import java.util.Collection;
import java.util.LinkedHashMap;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class AuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {
		final AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken "
					+ "must be created in order to execute a login attempt.";
			throw new IllegalStateException(msg);
		}
		try {
			final Subject subject = getSubject(request, response);
			Session session = subject.getSession();

			final LinkedHashMap<Object, Object> attributes = new LinkedHashMap<Object, Object>();
			final Collection<Object> keys = session.getAttributeKeys();
			for (Object key : keys) {
				final Object value = session.getAttribute(key);
				if (value != null) {
					attributes.put(key, value);
				}
			}
			session.stop();

			subject.login(token);
			// Restore the attributes.
			session = subject.getSession();
			for (final Object key : attributes.keySet()) {
				session.setAttribute(key, attributes.get(key));
			}
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			return onLoginFailure(token, e, request, response);
		}
	}
}