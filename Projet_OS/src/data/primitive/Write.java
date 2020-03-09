package data.primitive;

import data.drivers.Driver;
import process.visitor.OSPrimitiveVisitor;

public class Write {
	/*
	 *  This is the class of the Write primitive
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
	
	public Write(Driver driver) {
		this.setDriver(driver);
	}

	// getters and setters
	
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
