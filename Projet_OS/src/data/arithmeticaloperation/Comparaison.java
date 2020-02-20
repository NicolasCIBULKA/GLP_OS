package data.arithmeticaloperation;

import data.variable.Intvariable;
import process.visitor.ArrayListVisitor;

public class Comparaison extends Arithmeticaloperation{
	/*
	 * Abstract class of the test Operations
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private String comparator;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Comparaison(Intvariable a, Intvariable b, Intvariable result, String comparator) {
		super(a, b, result);
		this.setComparator(comparator);
	}

	// getters and setters
	
	public String getComparator() {
		return comparator;
	}

	public void setComparator(String comparator) {
		this.comparator = comparator;
	}

	@Override
	public <T> T accept(ArrayListVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		return this.getA().getContent() + this.getComparator() + this.getB().getContent() ;
	}
}
