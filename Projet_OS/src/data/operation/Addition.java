package data.operation;

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
	public Addition(float a, float b) {
		super(a,b);
	}
	
	public float calculate() {
		return getA()+getB();
	}
	
	
}
