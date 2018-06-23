package br.com.JRRMoraes.Questionador.Wildfly.Interceptadores;


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class InterceptadorParaLogs {

	@AroundInvoke
	public Object intercepta(InvocationContext contexto) throws Exception {
		long tempo = System.currentTimeMillis();

		Object objeto = contexto.proceed();

		tempo = System.currentTimeMillis() - tempo;
		System.out.println(String.format(">> %s . %s  == Tempo %3$tSs.%3$tLm",
				contexto.getTarget().getClass().getSimpleName(), contexto.getMethod().getName(), tempo));
		return objeto;
	}
}
