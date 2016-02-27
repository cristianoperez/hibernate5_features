package com.cristiano.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSession {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Produces
	@RequestScoped
	public Session getSession() {
		System.out.println("Produzindo session");
		return sessionFactory.openSession();
	}

	public void destroySession(@Disposes Session session) {
		session.close();
		System.out.println("Fechando session");
	}

}
