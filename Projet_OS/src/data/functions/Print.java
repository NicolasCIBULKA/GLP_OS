package data.functions;

import data.processus.Operation;
import data.variable.Stringvariable;
import data.variable.Variable;
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
	
	private Variable printop;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Print(Variable operation) {
		this.printop = operation;
		this.setCpuusing(50);
	}

	public Print(String line) {
		printop = new Stringvariable(line);
	}


	public Variable getPrintop() {
		return printop;
	}
	
	public void setPrintop(Variable printop) {
		this.printop = printop;
	}


	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String print() {
		return this.getPrintop().toString();
	}
}
