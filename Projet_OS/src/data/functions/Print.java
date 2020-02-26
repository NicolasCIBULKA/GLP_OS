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
	
	private String line;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Print(Operation operation) {
		this.setLine(operation.toString());
	}
	
	// getters and setters

	public Print(String line) {
		this.setLine(line);
	}

	
	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
	public String print() {
		return line.toString();
	}
}
