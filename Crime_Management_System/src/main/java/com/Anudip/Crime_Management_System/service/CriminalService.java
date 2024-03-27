package com.Anudip.Crime_Management_System.service;


import java.util.List;

import com.Anudip.Crime_Management_System.Dao.CriminalDao;
import com.Anudip.Crime_Management_System.model.Criminal;

public class CriminalService {
	 private final CriminalDao criminalDao;

	    public CriminalService() {
	        this.criminalDao = new CriminalDao();
	    }

	    public void addCriminal(Criminal criminal) {
	        criminalDao.addCriminal(criminal);
	    }

	    public Criminal getCriminalById(Long id) {
	        return criminalDao.getCriminalById(id);
	    }

	    public List<Criminal> getAllCriminals() {
	        return criminalDao.getAllCriminals();
	    }

	    public void updateCriminal(Criminal criminal) {
	        criminalDao.updateCriminal(criminal);
	    }

	    public void deleteCriminal(Criminal criminal) {
	        criminalDao.deleteCriminal(criminal);
	    }
}