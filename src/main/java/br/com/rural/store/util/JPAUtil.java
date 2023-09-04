package br.com.rural.store.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("ruralmarket");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}



