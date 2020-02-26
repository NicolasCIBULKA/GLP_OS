package data.primitive;

import data.drivers.Driver;

public class Write {
	/*
	 *  This is the driver of the Write primitive
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
}
