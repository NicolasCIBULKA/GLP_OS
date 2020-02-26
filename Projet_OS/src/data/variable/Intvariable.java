package data.variable;

import data.processus.Operation;

public class Intvariable extends Operation{
	/*
	 * This class contain a int for the processus execution
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int content;
	private String name;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor
	
	public Intvariable(String name, int content) {
		this.content = content;
		this.setName(name);
	}
	
	// getters and setters
	
	public int getContent() {
		return content;
	}

	public void setContent(int content) {
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
