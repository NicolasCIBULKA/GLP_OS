package data.variable;

import data.processus.Operation;

public class Stringvariable extends Operation {
	/*
	 * This class contain a String for the processus execution
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String content;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Stringvariable(String content) {
		this.content = content;
	}
	
	// getters and setters
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return this.getContent() + " " ;
	}
}
