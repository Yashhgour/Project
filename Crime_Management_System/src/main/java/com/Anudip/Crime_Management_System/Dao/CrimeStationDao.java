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
import com.Anudip.Crime_Management_System.model.CrimeStation;
import com.Anudip.Crime_Management_System.util.Utility;

public class CrimeStationDao {
	 public void addCrimeStation(CrimeStation station) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.persist(station);
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

	    public CrimeStation getCrimeStationById(Long id) {
	        EntityManager entityManager = Utility.provideConnection();
	        CrimeStation station = entityManager.find(CrimeStation.class, id);
	        entityManager.close();
	        return station;
	    }

	    public List<CrimeStation> getAllCrimeStations() {
	        EntityManager entityManager = Utility.provideConnection();
	        Query query = entityManager.createQuery("SELECT cs FROM CrimeStation cs");
	        List<CrimeStation> stations = query.getResultList();
	        entityManager.close();
	        return stations;
	    }

	    public void updateCrimeStation(CrimeStation station) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.merge(station);
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

	    public void deleteCrimeStation(CrimeStation station) {
	        EntityManager entityManager = Utility.provideConnection();
	        EntityTransaction transaction = entityManager.getTransaction();
	        try {
	            transaction.begin();
	            entityManager.remove(entityManager.contains(station) ? station : entityManager.merge(station));
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