package data;

import java.util.HashMap;

public abstract class Driver {
	
	/*
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
		
	private String driverID;
	private Interaction authorization;
	private HashMap<String, Peripheral> linkperipheral;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	/*
	 * This is the driver constructor, that create the link between the driver and the different
	 * 
	 *  peripheral that are connected to it
	 */
	public Driver(String driverID, Interaction authorization, HashMap<String, Peripheral> linkperipheral) {
		this.driverID = driverID;
		this.authorization = authorization;
		this.linkperipheral = linkperipheral;
	}
	
	// getters and setters
	
	
}
