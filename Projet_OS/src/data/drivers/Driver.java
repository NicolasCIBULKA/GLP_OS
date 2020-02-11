package data.drivers;

public abstract class Driver {
	
	/*
	 * This is the abstract class Driver
	 * 
	 * @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
		
	private String driverID;
	private Interaction authorization;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	/*
	 * This is the driver constructor, that create the link between the driver and the different
	 * 
	 *  peripheral that are connected to it
	 */
	
	// This is the constructor of the driver class 
	public Driver(String driverID, Interaction authorization) {
		this.setDriverID(driverID);
		this.setAuthorization(authorization);
	}

	// getters and setters
	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public Interaction getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Interaction authorization) {
		this.authorization = authorization;
	}
	
	
}
