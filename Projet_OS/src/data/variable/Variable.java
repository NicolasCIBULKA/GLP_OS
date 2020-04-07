package data.variable;

import data.processus.Operation;

public class Variable extends Operation{
	/*
	 * This class contain a String for the processus execution
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------

	private String name;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Variable(String name) {
		this.setName(name);
		this.setCpuusing(17);
	}

	public Variable() {
		
	}
	
	public String getName() {
		return name;
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
