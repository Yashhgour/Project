package com.Anudip.Crime_Management_System.service;


import java.util.List;

import com.Anudip.Crime_Management_System.Dao.CrimeStationDao;
import com.Anudip.Crime_Management_System.model.CrimeStation;

public class CrimeStationService {
	private final CrimeStationDao crimeStationDao;

    public CrimeStationService() {
        this.crimeStationDao = new CrimeStationDao();
    }

    public void addCrimeStation(CrimeStation station) {
        crimeStationDao.addCrimeStation(station);
    }

    public CrimeStation getCrimeStationById(Long id) {
        return crimeStationDao.getCrimeStationById(id);
    }

   
    public void updateCrimeStation(CrimeStation station) {
        crimeStationDao.updateCrimeStation(station);
    }

    public void deleteCrimeStation(CrimeStation station) {
        crimeStationDao.deleteCrimeStation(station);
    }

	public List<CrimeStation> getAllCrimeStations() {
		
		return crimeStationDao.getAllCrimeStations();
	}

	
}
