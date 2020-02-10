package data.iftest;

import java.util.ArrayList;

import data.processus.Operation;

public class Ifelseifelsetest extends TestOperation{
	/*
	 * Data class of the if elseif else Operation
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String elseifcondition;
	private ArrayList<Operation> elseifoperations;
	private ArrayList<Operation> elseoperations;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the Ifelseifelse data class
	public Ifelseifelsetest(String ifcondition, ArrayList<Operation> ifoperations, String elseifcondition,  ArrayList<Operation> elseifoperations, ArrayList<Operation> elseoperations) {
		super(ifoperations, ifcondition);
		this.setElseifcondition(elseifcondition);
		this.setElseifoperations(elseifoperations);
		this.setElseoperations(elseoperations);
	}

	// getters and setters 
	
	public String getElseifcondition() {
		return elseifcondition;
	}

	public void setElseifcondition(String elseifcondition) {
		this.elseifcondition = elseifcondition;
	}

	public ArrayList<Operation> getElseifoperations() {
		return elseifoperations;
	}

	public void setElseifoperations(ArrayList<Operation> elseifoperations) {
		this.elseifoperations = elseifoperations;
	}

	public ArrayList<Operation> getElseoperations() {
		return elseoperations;
	}

	public void setElseoperations(ArrayList<Operation> elseoperations) {
		this.elseoperations = elseoperations;
	}
}
