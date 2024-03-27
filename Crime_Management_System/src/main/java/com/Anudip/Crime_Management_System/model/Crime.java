package com.Anudip.Crime_Management_System.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Crime {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private CrimeStation station;

    private String dateAndPlace;
    
    private String victims;
    private String crimeDetails;
    private String mainSuspects;
	
    //default constructor
    public Crime() {
		super();
	}
    
    
	public Crime(Long id, String description, String location, String dateAndPlace, String victims, String crimeDetails,
			String mainSuspects) {
		super();
		this.id = id;
		this.description = description;
		this.location = location;
		this.dateAndPlace = dateAndPlace;
		this.victims = victims;
		this.crimeDetails = crimeDetails;
		this.mainSuspects = mainSuspects;
	}
   

	public Crime(Long id, String description, String location, CrimeStation station, String dateAndPlace,
			String victims, String crimeDetails, String mainSuspects) {
		super();
		this.id = id;
		this.description = description;
		this.location = location;
		this.station = station;
		this.dateAndPlace = dateAndPlace;
		this.victims = victims;
		this.crimeDetails = crimeDetails;
		this.mainSuspects = mainSuspects;
	}


	public Crime(Long id, String description, String location) {
	super();
	this.id = id;
	this.description = description;
	this.location = location;
}


	public CrimeStation getStation() {
		return station;
	}


	public void setStation(CrimeStation station) {
		this.station = station;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDateAndPlace() {
		return dateAndPlace;
	}


	public void setDateAndPlace(String dateAndPlace) {
		this.dateAndPlace = dateAndPlace;
	}


	public String getVictims() {
		return victims;
	}


	public void setVictims(String victims) {
		this.victims = victims;
	}


	public String getCrimeDetails() {
		return crimeDetails;
	}


	public void setCrimeDetails(String crimeDetails) {
		this.crimeDetails = crimeDetails;
	}


	public String getMainSuspects() {
		return mainSuspects;
	}


	public void setMainSuspects(String mainSuspects) {
		this.mainSuspects = mainSuspects;
	}


	@Override
	public String toString() {
		return "Crime [id=" + id + ", description=" + description + ", location=" + location + "]";
	}


	
}
