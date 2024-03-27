package com.Anudip.Crime_Management_System.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utility {
	private static EntityManagerFactory entityManagerFactory = null;
	  private static EntityManager entityManager = null;


  static {
  	entityManagerFactory = Persistence.createEntityManagerFactory("crimesystem");
      entityManager = entityManagerFactory.createEntityManager();
  }

  public static EntityManager provideConnection() {
      return entityManager;
  }
}
