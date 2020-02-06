package data.operation;

public class Multiplication extends Arithmeticaloperation{

	/*
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// constructor of the Multipliation class
	public Multiplication(float a, float b) {
		super(a,b);
	}
	
	// calculate
	public float calculate() {
		return getA()*getB();
	}
	
}
