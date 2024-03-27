package com.Anudip.Crime_Management_System.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Anudip.Crime_Management_System.model.Criminal;
import com.Anudip.Crime_Management_System.util.Utility;

public class CriminalDao {
	 public void addCriminal(Criminal criminal) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.persist(criminal);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    public Criminal getCriminalById(Long id) {
	        EntityManager entityManager = Utility.provideConnection();
	        Criminal criminal = entityManager.find(Criminal.class, id);
	        entityManager.close();
	        return criminal;
	    }

	    public List<Criminal> getAllCriminals() {
	        EntityManager entityManager = Utility.provideConnection();
	        Query query = entityManager.createQuery("SELECT c FROM Criminal c");
	        List<Criminal> criminals = query.getResultList();
	        entityManager.close();
	        return criminals;
	    }

	    public void updateCriminal(Criminal criminal) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.merge(criminal);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

	    public void deleteCriminal(Criminal criminal) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.remove(entityManager.contains(criminal) ? criminal : entityManager.merge(criminal));
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            entityManager.close();
	        }
	    }

}