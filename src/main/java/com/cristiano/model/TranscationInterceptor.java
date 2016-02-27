package com.cristiano.model;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.hibernate.Session;

@Interceptor
@TransactionManager
public class TranscationInterceptor {

	@Inject
	private Session session;
	
	@AroundInvoke
	public Object transactionResolver(InvocationContext ctx) throws Exception{
		TransactionManager annotation = ctx.getMethod().getAnnotation(TransactionManager.class);
		if(annotation != null){
			session.beginTransaction();
			Object obj = ctx.proceed();
			session.getTransaction().commit();
			System.out.println(session);
			return obj;
		}
		return ctx.proceed();
	}
}
