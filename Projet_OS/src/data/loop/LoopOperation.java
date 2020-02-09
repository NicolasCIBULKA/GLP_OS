package data.loop;

import java.util.ArrayList;

import data.processus.Operation;

public abstract class LoopOperation extends Operation{
	
	/*
	 * This is the abstract class of all the loop Operations, such
	 * 
	 * as "while" or "for"
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operations;
	
	// --------------------------------------
	// Methods
	// --------------------------------------

	// This is the constructors of the LoopOperation 
	public LoopOperation(ArrayList<Operation> operations) {
		this.setOperations(operations);
	}
	
	
	// getters and setters

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}
}
