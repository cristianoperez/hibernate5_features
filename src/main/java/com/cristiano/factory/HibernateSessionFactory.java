package com.cristiano.factory;

import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.jndi.JndiException;

public class HibernateSessionFactory {

	@Produces
	@ApplicationScoped
	public SessionFactory getSessionFactory() {
		System.out.println("Produzindo factory");
			return configureJNDI();
	}
	
	private SessionFactory configureJNDI(){
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.applySetting("hibernate.connection.datasource", "java:/comp/env/jdbc/cristiano")
				.build();
		return buildSessionFactory(serviceRegistry);
	}

	private SessionFactory configureLocal() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.applySetting("hibernate.connection.url", "jdbc:mysql://localhost:3306/db?autoReconnect=true&amp;autoReconnectForPools=true&amp;maxActive=20&amp;initialSize=10")
				.applySetting("hibernate.connection.username", "rooot")
				.applySetting("hibernate.connection.password", "root")
				.build();
		return buildSessionFactory(serviceRegistry);
	}
	
	private SessionFactory buildSessionFactory(StandardServiceRegistry serviceRegistry){
		return new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	}

}
