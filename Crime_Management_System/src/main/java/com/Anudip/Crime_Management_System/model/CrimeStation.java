package com.Anudip.Crime_Management_System.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CrimeStation {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToMany(mappedBy = "station")
	    private List<Crime> crimes = new ArrayList<>();

	   @Column(name = "name")
	    private String name;
	   
	   @Column(name = "location")
	    private String location;
		
		public CrimeStation() {
			super();
		}
		public CrimeStation(String location, String name) {
		    this.location = location;
		    this.name = name;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public List<Crime> getCrimes() {
			return crimes;
		}
		public void setCrimes(List<Crime> crimes) {
			this.crimes = crimes;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		public CrimeStation(Long id, List<Crime> crimes, String name, String location) {
			super();
			this.id = id;
			this.crimes = crimes;
			this.name = name;
			this.location = location;
		}
		@Override
		public String toString() {
			return "CrimeStation [id=" + id + ", crimes=" + crimes + ", name=" + name + ", location=" + location + "]";
		}
	    
	    
} 
