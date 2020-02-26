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
	private String name;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Stringvariable(String name, String content) {
		this.content = content;
		this.setName(name);
	}
	
	// getters and setters
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.getContent() + " " ;
	}
}
