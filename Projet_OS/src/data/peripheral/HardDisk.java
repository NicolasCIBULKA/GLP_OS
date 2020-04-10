package data.peripheral;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import data.drivers.FullHDException;
import data.drivers.HardDiskDriver;
import data.drivers.Interaction;


public class HardDisk extends Peripheral {
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private boolean canAddContent;
	private HashMap<String,Slot> slotlist = new HashMap();
	
	private int slotnumber = 0;
	private int maxSlot = 5;
	PrintStream writer;
	File HardDisk = new File("/Users/theomarmeisse/Desktop/harddisks");
	File info;
	

	// Constructor

	public HardDisk(String peripheralid) {
		super(peripheralid);
		File[] children = HardDisk.listFiles();
		for (int i=0; children != null && i<children.length; i++) {
		children[i].delete(); 
		}
		
		HardDisk.mkdir();
	        
		info = new File("/Users/theomarmeisse/Desktop/harddisks/info.csv");
		info.delete();
		try {
			 writer = new PrintStream(new FileOutputStream(info,true));
			writer.println("Slot; Taille(en bytes)");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int getMaxSlot() {
		return maxSlot;
	}
	
	public void setMaxSlot(int maxSlot) {
		this.maxSlot = maxSlot;
	}
	

		
	

	public boolean isCanAddContent() {
		return canAddContent;
	}

	public void setCanAddContent(boolean canAddContent) {
		this.canAddContent = canAddContent;
	}

	public HashMap<String, Slot> getSlotlist() {
		return slotlist;
	}
	
	public void setSlotlist(HashMap<String, Slot> slotlist) {
		this.slotlist = slotlist;
	}
	
	public int getSlotnumber() {
		return slotnumber;
	}
	
	public void incrementSlotnumber() {
		this.slotnumber = slotnumber++;
	}
	public void decrementSlotnumber() {
		this.slotnumber = slotnumber--;
	}
	public File getInfo() {
		return info;
	}
	
	
	

}