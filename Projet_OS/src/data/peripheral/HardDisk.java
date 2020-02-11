package data.peripheral;

import java.util.HashMap;

import data.processus.Processus;

public class HardDisk extends Peripheral {
	
	private boolean isRunning;
	private String content;
	private boolean canAddContent;
	private HashMap<Integer,Slot> slotlist;
	private int slotnumber = 1;

	public HardDisk(Slot slot, String peripheralid) {
		super(peripheralid);
		slotlist.put(slotnumber, slot);
		slotnumber++;
		isRunning = true;
		content = "";
		canAddContent = true;
	}
	public void addSlot(int size,Processus processus) {
		Slot slot = new Slot(size,processus);
		slotlist.put(slotnumber, slot);
		slotnumber++;
	}

	public boolean isCanAddContent() {
		return canAddContent;
	}

	public void setCanAddContent(boolean canAddContent) {
		this.canAddContent = canAddContent;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	

}
