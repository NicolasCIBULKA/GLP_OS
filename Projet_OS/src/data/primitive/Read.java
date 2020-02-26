package data.primitive;

import data.drivers.Driver;

public class Read {
	/*
	 *  This is the primitive of the Read primitive
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
	
	public Read(Driver driver) {
		this.setDriver(driver);
	}

	// Getters and setters
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
}
