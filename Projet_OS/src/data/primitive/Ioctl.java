package data.primitive;

import data.drivers.Driver;

public class Ioctl{
	/*
	 *  This is the primitive of execution primitive
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
	
	public Ioctl(Driver driver) {
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
