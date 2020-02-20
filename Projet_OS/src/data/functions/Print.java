package data.functions;

import data.processus.Operation;
import process.visitor.ArrayListVisitor;

public class Print extends Operation{
	/*
	 * This is the Class that will print the result of all the primitives & functions
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private Operation operation;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Print(Operation operation) {
		this.setOperation(operation);
	}
	
	// getters and setters

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
	public String print() {
		return operation.toString();
	}
}
