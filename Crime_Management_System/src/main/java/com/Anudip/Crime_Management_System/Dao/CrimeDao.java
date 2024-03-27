package com.Anudip.Crime_Management_System.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Anudip.Crime_Management_System.model.Crime;
import com.Anudip.Crime_Management_System.util.Utility;

public class CrimeDao {
	public void addCrime(Crime crime) {
        EntityManager entityManager = Utility.provideConnection();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(crime);
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

    public Crime getCrimeById(Long id) {
        EntityManager entityManager = Utility.provideConnection();
        Crime crime = entityManager.find(Crime.class, id);
        entityManager.close();
        return crime;
    }

    public List<Crime> getAllCrimes() {
        EntityManager entityManager = Utility.provideConnection();
        Query query = entityManager.createQuery("SELECT c FROM Crime c");
        List<Crime> crimes = query.getResultList();
        entityManager.close();
        return crimes;
    }

    public void updateCrime(Crime crime) {
        EntityManager entityManager = Utility.provideConnection();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(crime);
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

    public void deleteCrime(Crime crime) {
        EntityManager entityManager = Utility.provideConnection();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(crime) ? crime : entityManager.merge(crime));
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
