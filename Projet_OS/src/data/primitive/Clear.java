package data.primitive;

import data.drivers.Driver;
import process.visitor.OSPrimitiveVisitor;
import process.visitor.PrimitiveVisitor;

public class Clear {
	/*
	 *  This is the class of the clear primitive
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private Driver driver;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Clear(Driver driver) {
		this.driver = driver;
	}
	
	// Getters and setters

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	// primitive visitor
	
	public <T> T accept(OSPrimitiveVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	
}
