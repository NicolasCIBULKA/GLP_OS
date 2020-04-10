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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
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
	public void deleteSlot() {
		slot.delete();
	}
	


	public void write(String text) throws StringIndexOutOfBoundsException {
		int sizeEntry = text.length();
		if(sizeEntry + size >= sizeMax) {
			throw new StringIndexOutOfBoundsException();
		}
		else
		try {
            PrintStream writer = new PrintStream(new FileOutputStream(slot,true));
          
            try {
                 writer.print(text);
              
            } finally {
                 writer.close(); 
            }
          
       } catch (IOException e) {
            e.printStackTrace();
       }
		
		size = size + sizeEntry;
	}

	public void read() { 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(slot));
			try {
		      String CurrentLine;
		      while ((CurrentLine = reader.readLine()) != null) {
		        System.out.println(CurrentLine);
		      }
			}
		      finally {
		    	  reader.close();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
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
}
