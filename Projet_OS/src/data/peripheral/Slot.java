package data.peripheral;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;


public class Slot {

	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private String slotposition;
	File slot;
	String name;
	boolean slotFile;
	int sizeMax = 2000;
	int size;

	private static String fileposition = "/Users/theomarmeisse/Desktop/harddisks/";
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Slot(String name) {
		this.name = name;
		this.setSlotposition(fileposition + name);
		 slot = new File(fileposition + name);
		 try {
			slotFile = new File(fileposition + name).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	public void delete( ) {
		slot.delete();
	}
	
	
	// getters and setters
	
	public String getSlotposition() {
		return slotposition;
	}
	
	public void setSlotposition(String slotposition) {
		this.slotposition = slotposition;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	




	public long getByteSize() {
		long size = slot.length();
		size = size*8;
		return size;
	}
	public int getCharSize() {
		return size;
	}
	public int getMaxSize() {
		return sizeMax;
	}
	public File getSlot() {
		return slot;
	}
}
