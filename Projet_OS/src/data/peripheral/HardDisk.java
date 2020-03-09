package data.peripheral;

import java.util.HashMap;
import data.drivers.FullHDException;


public class HardDisk extends Peripheral {
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private boolean canAddContent;
	private HashMap<Integer,Slot> slotlist;
	private int slotnumber = 0;
	private int maxSlot = 0;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor

	public HardDisk(Slot slot, String peripheralid) {
		super(peripheralid);
		slotnumber++;
		slotlist.put(slotnumber, slot);
		canAddContent = true;
		maxSlot++;
	}
	
	// methods
	
	public void addSlot(String name) throws FullHDException{
		if(maxSlot == 5) {
			throw new FullHDException();
		}
		Slot slot = new Slot(name);
		slotlist.put(slotnumber, slot);
		slotnumber++;
	}
	
	public int getMaxSlot() {
		return maxSlot;
	}
	
	public void setMaxSlot(int maxSlot) {
		this.maxSlot = maxSlot;
	}
	
	public void eraseSlot(int slotnumber) {
		slotlist.remove(slotnumber);
	}

	public boolean isCanAddContent() {
		return canAddContent;
	}

	public void setCanAddContent(boolean canAddContent) {
		this.canAddContent = canAddContent;
	}

	public HashMap<Integer, Slot> getSlotlist() {
		return slotlist;
	}
	
	public void setSlotlist(HashMap<Integer, Slot> slotlist) {
		this.slotlist = slotlist;
	}
	
	public int getSlotnumber() {
		return slotnumber;
	}
	
	public void setSlotnumber(int slotnumber) {
		this.slotnumber = slotnumber;
	}

	

}