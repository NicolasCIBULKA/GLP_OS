package data.operation;

public class Substraction extends Arithmeticaloperation{
	
	/*
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the Substraction class
	public Substraction(float a, float b) {
		super(a,b);
	}
	
	// calculate
	public float calculate() {
		return getA()-getB();
	}
}
