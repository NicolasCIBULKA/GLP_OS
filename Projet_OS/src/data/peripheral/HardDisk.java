package data.peripheral;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;


public class HardDisk extends Peripheral {
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private boolean canAddContent;
	private HashMap<String,Slot> slotlist = new HashMap<String,Slot>();
	
	private int slotnumber = 0;
	private int maxSlot = 5;
	PrintStream writer;
	int hdNumber = 1; 
	File HardDisk ;
	String hdPosition;
	File info;
	
	
	// Constructor

	public HardDisk(String peripheralid,String hdPosition) {
		super(peripheralid);
		this.hdPosition = hdPosition;
		HardDisk = new File(hdPosition);
		
		
	        
		info = new File(hdPosition+"/info.csv");
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


	public void setSlotnumber(int slotnumber) {
		this.slotnumber = slotnumber;
	}


	public int getHdNumber() {
		return hdNumber;
	}


	public String getHdPosition() {
		return hdPosition;
	}
	
	
	
	

}