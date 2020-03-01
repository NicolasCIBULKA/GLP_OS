package data.arithmeticaloperation;

import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public class Division extends Arithmeticaloperation{
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
	
	
	// constructor
	
	public Division(Intvariable a, Intvariable b, Intvariable result) {
		super(a, b, result);
	}

	// Visitor
	
	@Override
	public <T> T accept(ArrayListVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// toString
	
	public String toString() {
		return getA().getContent() + " / " + getB().getContent() + " = " + this.getResult().getContent();
	}

}
