package com.Anudip.Crime_Management_System.usecase;

import java.util.List;
import java.util.Scanner;

import com.Anudip.Crime_Management_System.model.Crime;
import com.Anudip.Crime_Management_System.model.CrimeStation;
import com.Anudip.Crime_Management_System.model.Criminal;
import com.Anudip.Crime_Management_System.service.CrimeService;
import com.Anudip.Crime_Management_System.service.CrimeStationService;
import com.Anudip.Crime_Management_System.service.CriminalService;

public class Main {
	  private static final Scanner scanner = new Scanner(System.in);
	    private static final CrimeService crimeService = new CrimeService();
	    private static final CrimeStationService crimeStationService = new CrimeStationService();
	    private static final CriminalService criminalService = new CriminalService();

	    public static void main(String[] args) {
	    	 boolean exit = false;

	         while (!exit) {
	             System.out.println("\nCrime Management System");
	             System.out.println("1. Add Crime");
	             System.out.println("2. Add Crime Station");
	             System.out.println("3. Add Criminal");
	             System.out.println("4. View All Crimes");
	             System.out.println("5. View All Crime Stations");
	             System.out.println("6. View All Criminals");
	             System.out.println("7. Update Crime");
	             System.out.println("8. Update Crime Station");
	             System.out.println("9. Update Criminal");
	             System.out.println("10. Delete Crime");
	             System.out.println("11. Delete Crime Station");
	             System.out.println("12. Delete Criminal");
	             System.out.println("13. Exit");
	             System.out.print("Choose an option: ");

	             int choice = scanner.nextInt();
	             scanner.nextLine(); // Consume newline

	             switch (choice) {
	                 case 1:
	                     addCrime();
	                     break;
	                 case 2:
	                     addCrimeStation();
	                     break;
	                 case 3:
	                     addCriminal();
	                     break;
	                 case 4:
	                     viewAllCrimes();
	                     break;
	                 case 5:
	                     viewAllCrimeStations();
	                     break;
	                 case 6:
	                     viewAllCriminals();
	                     break;
	                 case 7:
	                     updateCrime();
	                     break;
	                 case 8:
	                     updateCrimeStation();
	                     break;
	                 case 9:
	                     updateCriminal();
	                     break;
	                 case 10:
	                     deleteCrime();
	                     break;
	                 case 11:
	                     deleteCrimeStation();
	                     break;
	                 case 12:
	                     deleteCriminal();
	                     break;
	                     
	                 case 13:
	                     exit = true;
	                     break;
	                 default:
	                     System.out.println("Invalid choice. Please try again.");
	             }
	         }
	     }

	     private static void addCrime() {
	         System.out.print("Enter Crime details...\nDate and Place: ");
	         String dateAndPlace = scanner.nextLine();
	         System.out.print("Description: ");
	         String description = scanner.nextLine();
	         System.out.print("Victims: ");
	         String victims = scanner.nextLine();
	         System.out.print("Crime Details: ");
	         String crimeDetails = scanner.nextLine();
	         System.out.print("Main Suspects: ");
	         String mainSuspects = scanner.nextLine();

	         Crime crime = new Crime();
	         crime.setDateAndPlace(dateAndPlace);
	         crime.setDescription(description);
	         crime.setVictims(victims);
	         crime.setCrimeDetails(crimeDetails);
	         crime.setMainSuspects(mainSuspects);

	         crimeService.addCrime(crime);
	         System.out.println("Crime added successfully.");
	     }

	     private static void addCrimeStation() {
	         System.out.print("Enter Crime Station details...\nName: ");
	         String name = scanner.nextLine();
	         System.out.print("Location: ");
	         String location = scanner.nextLine();

	         CrimeStation station = new CrimeStation();
	         station.setName(name);
	         station.setLocation(location);

	         crimeStationService.addCrimeStation(station);
	         System.out.println("Crime Station added successfully.");
	     }

	     private static void addCriminal() {
	         System.out.print("Enter Criminal details...\nName: ");
	         String name = scanner.nextLine();
	         System.out.print("Age: ");
	         int age = scanner.nextInt();
	         scanner.nextLine(); // Consume newline
	         System.out.print("Gender: ");
	         String gender = scanner.nextLine();
	         System.out.print("Address: ");
	         String address = scanner.nextLine();
	         System.out.print("Identifying Mark: ");
	         String identifyingMark = scanner.nextLine();
	         System.out.print("Area of Arrest: ");
	         String areaOfArrest = scanner.nextLine();
	         System.out.print("Crime Attached: ");
	         String crimeAttached = scanner.nextLine();

	         Criminal criminal = new Criminal();
	         criminal.setName(name);
	         criminal.setAge(age);
	         criminal.setGender(gender);
	         criminal.setAddress(address);
	         criminal.setIdentifyingMark(identifyingMark);
	         criminal.setAreaOfArrest(areaOfArrest);
	         criminal.setCrimeAttached(crimeAttached);

	         criminalService.addCriminal(criminal);
	         System.out.println("Criminal added successfully.");
	     }
	     
	     private static void viewAllCrimes() {
	         List<Crime> crimes = crimeService.getAllCrimes();
	         if (crimes.isEmpty()) {
	             System.out.println("No crimes found.");
	         } else {
	             System.out.println("All Crimes:");
	             crimes.forEach(System.out::println);
	         }
	     }

	     private static void viewAllCrimeStations() {
	         List<CrimeStation> stations = crimeStationService.getAllCrimeStations();
	         if (stations.isEmpty()) {
	             System.out.println("No crime stations found.");
	         } else {
	             System.out.println("All Crime Stations:");
	             stations.forEach(System.out::println);
	         }
	     }

	     private static void viewAllCriminals() {
	         List<Criminal> criminals = criminalService.getAllCriminals();
	         if (criminals.isEmpty()) {
	             System.out.println("No criminals found.");
	         } else {
	             System.out.println("All Criminals:");
	             criminals.forEach(System.out::println);
	         }
	     }
	     
	     private static void updateCrime() {
	         System.out.print("Enter Crime ID to update: ");
	         Long crimeId = scanner.nextLong();
	         scanner.nextLine(); // Consume newline

	         Crime crime = crimeService.getCrimeById(crimeId);
	         if (crime == null) {
	             System.out.println("Crime with ID " + crimeId + " not found.");
	             return;
	         }

	         System.out.print("Enter updated Date and Place: ");
	         String dateAndPlace = scanner.nextLine();
	         System.out.print("Updated Description: ");
	         String description = scanner.nextLine();
	         System.out.print("Updated Victims: ");
	         String victims = scanner.nextLine();
	         System.out.print("Updated Crime Details: ");
	         String crimeDetails = scanner.nextLine();
	         System.out.print("Updated Main Suspects: ");
	         String mainSuspects = scanner.nextLine();

	         crime.setDateAndPlace(dateAndPlace);
	         crime.setDescription(description);
	         crime.setVictims(victims);
	         crime.setCrimeDetails(crimeDetails);
	         crime.setMainSuspects(mainSuspects);

	         crimeService.updateCrime(crime);
	         System.out.println("Crime updated successfully.");
	     }

	     private static void deleteCrime() {
	    	    System.out.print("Enter Crime ID to delete: ");
	    	    Long crimeId = scanner.nextLong();
	    	    scanner.nextLine(); // Consume newline

	    	    Crime crime = crimeService.getCrimeById(crimeId);
	    	    if (crime == null) {
	    	        System.out.println("Crime with ID " + crimeId + " not found.");
	    	        return;
	    	    }

	    	    crimeService.deleteCrime(crime);
	    	    System.out.println("Crime deleted successfully.");
	    	}
	     
	     private static void updateCrimeStation() {
	    	    System.out.print("Enter Crime Station ID to update: ");
	    	    Long stationId = scanner.nextLong();
	    	    scanner.nextLine(); // Consume newline

	    	    CrimeStation station = crimeStationService.getCrimeStationById(stationId);
	    	    if (station == null) {
	    	        System.out.println("Crime Station with ID " + stationId + " not found.");
	    	        return;
	    	    }

	    	    System.out.print("Enter updated Crime Station name: ");
	    	    String name = scanner.nextLine();
	    	    System.out.print("Enter updated Crime Station location: ");
	    	    String location = scanner.nextLine();

	    	    station.setName(name);
	    	    station.setLocation(location);

	    	    crimeStationService.updateCrimeStation(station);
	    	    System.out.println("Crime Station updated successfully.");
	    	}
	     
	     private static void deleteCrimeStation() {
	    	    System.out.print("Enter Crime Station ID to delete: ");
	    	    Long stationId = scanner.nextLong();
	    	    scanner.nextLine(); // Consume newline

	    	    CrimeStation station = crimeStationService.getCrimeStationById(stationId);
	    	    if (station == null) {
	    	        System.out.println("Crime Station with ID " + stationId + " not found.");
	    	        return;
	    	    }

	    	    crimeStationService.deleteCrimeStation(station);
	    	    System.out.println("Crime Station deleted successfully.");
	    	}

	     private static void updateCriminal() {
	    	    System.out.print("Enter Criminal ID to update: ");
	    	    Long criminalId = scanner.nextLong();
	    	    scanner.nextLine(); // Consume newline

	    	    Criminal criminal = criminalService.getCriminalById(criminalId);
	    	    if (criminal == null) {
	    	        System.out.println("Criminal with ID " + criminalId + " not found.");
	    	        return;
	    	    }

	    	    System.out.print("Enter updated Criminal name: ");
	    	    String name = scanner.nextLine();
	    	    System.out.print("Enter updated Criminal age: ");
	    	    int age = scanner.nextInt();
	    	    scanner.nextLine(); // Consume newline
	    	    System.out.print("Enter updated Criminal gender: ");
	    	    String gender = scanner.nextLine();
	    	    System.out.print("Enter updated Criminal address: ");
	    	    String address = scanner.nextLine();
	    	    System.out.print("Enter updated Criminal identifying mark: ");
	    	    String identifyingMark = scanner.nextLine();
	    	    System.out.print("Enter updated Criminal area of arrest: ");
	    	    String areaOfArrest = scanner.nextLine();
	    	    System.out.print("Enter updated Crime attached: ");
	    	    String crimeAttached = scanner.nextLine();

	    	    criminal.setName(name);
	    	    criminal.setAge(age);
	    	    criminal.setGender(gender);
	    	    criminal.setAddress(address);
	    	    criminal.setIdentifyingMark(identifyingMark);
	    	    criminal.setAreaOfArrest(areaOfArrest);
	    	    criminal.setCrimeAttached(crimeAttached);

	    	    criminalService.updateCriminal(criminal);
	    	    System.out.println("Criminal updated successfully.");
	    	}
	     
	          private static void deleteCriminal() {
	    	    System.out.print("Enter Criminal ID to delete: ");
	    	    Long criminalId = scanner.nextLong();
	    	    scanner.nextLine(); // Consume newline

	    	    Criminal criminal = criminalService.getCriminalById(criminalId);
	    	    if (criminal == null) {
	    	        System.out.println("Criminal with ID " + criminalId + " not found.");
	    	        return;
	    	    }

	    	    criminalService.deleteCriminal(criminal);
	    	    System.out.println("Criminal deleted successfully.");
	    	}
	    	
}