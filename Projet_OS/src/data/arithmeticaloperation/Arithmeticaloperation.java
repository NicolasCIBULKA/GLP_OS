package data.arithmeticaloperation;

import data.processus.Operation;

public abstract class Arithmeticaloperation extends Operation{
	/*
	 * 
	 * @author Nicolas CIBULKA
	 */
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private float a;
	private float b;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the ArithmeticalOperation
	public Arithmeticaloperation(float a, float b) {
		this.setA(a);
		this.setB(b);
	}
	
	// getters and setters
	
	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}
	
	// calculate
	
	public abstract float calculate();
	

	
	
}
