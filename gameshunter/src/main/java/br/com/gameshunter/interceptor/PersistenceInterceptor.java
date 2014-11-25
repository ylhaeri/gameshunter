package br.com.gameshunter.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PersistenceInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// Usado quando o server é encerrado
	}

	@Override
	public void init() {
		// Usado quando o server é iniciado
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// Executa o request
		String result = invocation.invoke();

		// Entrega a response para o browser
		return result;
	}
}