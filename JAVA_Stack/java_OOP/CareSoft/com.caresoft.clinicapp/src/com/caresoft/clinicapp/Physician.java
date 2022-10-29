package com.caresoft.clinicapp;
import java.util.*;
public class Physician extends User implements HIPAACompliantUser{
//... imports class definition...
    // Inside class:    
    private ArrayList<String> patientNotes;
    public Physician(Integer id) {
    	super(id);
    }
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
	   	if(pin > 0000 && pin < 9999) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == this.id) {
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	
    // TO DO: Setters & Getters
}
