package data.arithmeticaloperation;

import data.processus.Operation;
import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public abstract class Arithmeticaloperation extends Operation{
	/*
	 * 
	 * @author Nicolas CIBULKA
	 */
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private Intvariable a;
	private Intvariable b;
	private Intvariable result;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the ArithmeticalOperation
	public Arithmeticaloperation(Intvariable a, Intvariable b, Intvariable result) {
		this.setA(a);
		this.setB(b);
		this.setResult(result);
	}
	
	// getters and setters
	
	public Intvariable getA() {
		return a;
	}

	public void setA(Intvariable a) {
		this.a = a;
	}

	public Intvariable getB() {
		return b;
	}

	public void setB(Intvariable b) {
		this.b = b;
	}
	
	
	public Intvariable getResult() {
		return result;
	}

	public void setResult(Intvariable result) {
		this.result = result;
	}

	public abstract <T> T accept(ArrayListVisitor<T> visitor); 
	
	
}
