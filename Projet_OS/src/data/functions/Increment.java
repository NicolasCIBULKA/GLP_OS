package data.functions;

import data.processus.Operation;
import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public class Increment extends Operation{
	/*
	 * This is the function that increment a Intvariable 
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private Intvariable var;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Increment(Intvariable var) {
		this.setVar(var);
	}
	
	// getters and setters
	
	public Intvariable getVar() {
		return var;
	}

	public void setVar(Intvariable var) {
		this.var = var;
	}

	// Visitor
	
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
