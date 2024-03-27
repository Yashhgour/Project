package com.Anudip.Crime_Management_System.service;

import java.util.List;

import com.Anudip.Crime_Management_System.Dao.CrimeDao;
import com.Anudip.Crime_Management_System.model.Crime;

public class CrimeService {
	 private final CrimeDao crimeDao;

	    public CrimeService() {
	        this.crimeDao = new CrimeDao();
	    }

	    public void addCrime(Crime crime) {
	        crimeDao.addCrime(crime);
	    }

	    public Crime getCrimeById(Long id) {
	        return crimeDao.getCrimeById(id);
	    }

	    public void updateCrime(Crime crime) {
	        crimeDao.updateCrime(crime);
	    }

	    public void deleteCrime(Crime crime) {
	        crimeDao.deleteCrime(crime);
	    }

		public List<Crime> getAllCrimes() {
			// TODO Auto-generated method stub
			return crimeDao.getAllCrimes();
		}
}
