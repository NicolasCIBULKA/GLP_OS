package data;

public abstract class Driver {
	
	/*
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
		
	private String driverID;
	private Interaction authorization;
	private String linkperipheral;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	/*
	 * This is the driver constructor, that create the link between the driver and the different
	 * 
	 *  peripheral that are connected to it
	 */
	
	// This is the constructor of the driver class 
	public Driver(String driverID, Interaction authorization, String linkperipheral) {
		this.setDriverID(driverID);
		this.setAuthorization(authorization);
		this.setLinkperipheral(linkperipheral);
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

	public String getLinkperipheral() {
		return linkperipheral;
	}

	public void setLinkperipheral(String linkperipheral) {
		this.linkperipheral = linkperipheral;
	}
	
	
	
	
}
