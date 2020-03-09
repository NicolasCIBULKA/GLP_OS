package data.primitive;

import data.drivers.ScreenDriver;
import data.peripheral.Slot;
import process.visitor.OSPrimitiveVisitor;

public class Delete {
	/*
	 * This is the data class of the Delete Primitive 
	 * 
	 * This class allow us to delete a line in a HardDisk slot or to fully wipe it
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private Slot slot;
	private String parameter;
	private ScreenDriver scdriver;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	public Delete(ScreenDriver scdriver, Slot slot, String parameter) {
		this.setSlot(slot);
		this.setParameter(parameter);
	}

	// getters and setters
	
	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	

	
		public ScreenDriver getScdriver() {
		return scdriver;
	}

	public void setScdriver(ScreenDriver scdriver) {
		this.scdriver = scdriver;
	}

	
	// primitive visitor
	
	public <T> T accept(OSPrimitiveVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
