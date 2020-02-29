package data.arithmeticaloperation;

import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public class Addition extends Arithmeticaloperation{
	/*
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the Constructor of the class Addition
	public Addition(Intvariable a, Intvariable b, Intvariable result) {
		super(a,b, result);
	}
	
	
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public int calculate() {
		return this.getA().getContent() + this.getB().getContent();
	}
	
	public String toString() {
		return getA().getContent() + " + " + getB().getContent() + " = " + this.getResult().getContent();
	}
	
}
