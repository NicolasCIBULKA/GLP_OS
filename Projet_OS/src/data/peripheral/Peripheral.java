package data.peripheral;

public abstract class Peripheral {
	/**
	 * All the peripheral inherit of this abstract class to get their id
	 * 
	 * @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private String peripheralid;
	// --------------------------------------
	// Methods
	// --------------------------------------	

	/*
	 * This is the constructor of the Abstract class
	 */
	public Peripheral(String peripheralid) {
		this.peripheralid = peripheralid;
	}
	
	// getters and setters
	public String getperipheralid(){
		return peripheralid;
	}
	
	public void setperipheralid(String peripheralid) {
		this.peripheralid = peripheralid;
	}
	
}
