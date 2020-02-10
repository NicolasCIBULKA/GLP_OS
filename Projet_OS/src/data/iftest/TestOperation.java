package data.iftest;

import java.util.ArrayList;
import data.processus.Operation;

public abstract class TestOperation extends Operation{
	/*
	 * Abstract class of the test Operations
	 * 
	 * @author Nicolas CIBULKA
	 */

	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operations;
	private String ifcondition;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the testOperation class
	
	public TestOperation(ArrayList<Operation> operations, String ifcondition) {
		this.setOperations(operations);
		this.setIfcondition(ifcondition);		
	}
	
	//getters and setters

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	public String getIfcondition() {
		return ifcondition;
	}

	public void setIfcondition(String ifcondition) {
		this.ifcondition = ifcondition;
	}
	
}
