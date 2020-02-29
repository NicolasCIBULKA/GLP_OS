package process.rrobin;

import java.util.HashMap;

import data.variable.Intvariable;
import data.variable.Stringvariable;

public class Variablebuffer {
	/*
	 *  This is the class that allow us to stock the variables
	 *  
	 *  during the process of a processus
	 *  
	 *  @Author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------

	private HashMap<String, Intvariable> intvariablelist;
	private HashMap<String, Stringvariable> stringvariablelist;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Variablebuffer() {
		intvariablelist = new HashMap<String, Intvariable>();
		stringvariablelist = new HashMap<String, Stringvariable>();
	}

	public HashMap<String, Intvariable> getIntvariablelist() {
		return intvariablelist;
	}

	public void setIntvariablelist(HashMap<String, Intvariable> intvariablelist) {
		this.intvariablelist = intvariablelist;
	}

	public HashMap<String, Stringvariable> getStringvariablelist() {
		return stringvariablelist;
	}

	public void setStringvariablelist(HashMap<String, Stringvariable> stringvariablelist) {
		this.stringvariablelist = stringvariablelist;
	}
	
	public void clearVariablebuffer() {
		this.getIntvariablelist().clear();
		this.getStringvariablelist().clear();
	}
	
	
	
	
	
}
