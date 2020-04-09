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
	
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
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
	
	// methods
	
	public void addSlot(Slot slot) throws FullHDException{
		if(slotnumber == maxSlot || slotlist.containsKey(slot.getName())) {
			throw new FullHDException();
		}
		slotlist.put(slot.getName(), slot);
		try {
			writer = new PrintStream(new FileOutputStream(info,true));
			writer.println(slot.getName()+";"+ slot.getSize()+";");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		slotnumber++;
	}
	
	public int getMaxSlot() {
		return maxSlot;
	}
	
	public void setMaxSlot(int maxSlot) {
		this.maxSlot = maxSlot;
	}
	
	public void eraseSlot(String slotName) {
		Slot s = slotlist.get(slotName);
		slotlist.remove(slotName);
		   
       try { File tempFile = new File(info.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader("/Users/theomarmeisse/Desktop/harddisks/info.csv"));
         writer = new PrintStream(new FileOutputStream(tempFile));
        String line = null;

        
        while ((line = br.readLine()) != null) {
        	String[] slot = line.split(";");
        	String value = slot[0];
            if (!value.equals(slotName)) {
                writer.println(line);
            }
        }
        writer.close();
        br.close();

        
        if (!info.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        
        if (!tempFile.renameTo(info))
            System.out.println("Could not rename file");
        }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
       s.deleteSlot();
       
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
	
	public void setSlotnumber(int slotnumber) {
		this.slotnumber = slotnumber;
	}
	
	public static void main(String[] args) {
		HardDisk hd = new HardDisk("12");
		Slot slot1 = new Slot("Slot1");
		Slot slot2 = new Slot("Slot2");
		Slot slot3 = new Slot("Slot3");
		try {
			hd.addSlot(slot1);
		} catch (FullHDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			hd.addSlot(slot2);
		} catch (FullHDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			hd.addSlot(slot3);
		} catch (FullHDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		slot1.write("BABAABUYHT");
		slot2.write("2+2 76");
		slot3.write("ASTALABAMBA");
		hd.eraseSlot("Slot2");
		
	}
	

}