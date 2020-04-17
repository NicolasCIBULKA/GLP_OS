package process.traduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import data.drivers.*;
import data.processus.Processus;
import process.rrobin.Rrobin;

public class Primitivetranscriptor extends Thread{
	
	/*
	 *  This is the class that will translate a primitive that come from the keyboard to a program to do
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Constant
	// --------------------------------------
	
	private static int primitive_identifier = 0;
	private static String HardDisks_position = "./src/";
	
	// --------------------------------------
	// Attributs
	// --------------------------------------

	private ScreenDriver scdriver;
	private Rrobin roundrobin;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Primitivetranscriptor(Rrobin roundrobin) {
		//this.setScdriver(scdriver);
		this.setRoundrobin(roundrobin);
	}
	
	// transcription method
	
	public void transcriptor(String input, ScreenDriver scdriver, HardDiskDriver hd1, HardDiskDriver hd2) {
		// we split the input in a tab to manipulate it
		String[] tabinput = input.split(" ");
		if(tabinput.length == 6){
			// if the primitive is a forkexec
			if(tabinput[primitive_identifier].contains("forkexec")) {
				// we translate the file into a processus
				Transcriptor proctr = new Transcriptor();
				Processus proc = new Processus();
				String slotname = tabinput[4];
				String hdname = tabinput[2];
				String selectedhd =" ";
				
				if(hdname.contentEquals("hd1")) {
					selectedhd = "harddisks1/";
				}
				else if(hdname.contentEquals("hd2")) {
					selectedhd = "harddisks2/";
				}
				String path = "./src/"+selectedhd+slotname;
				File file = new File(path);
				if (file.exists()) {
					// we need to test before adding slot (doing it when the HD is ready)
					String slotadress = HardDisks_position + selectedhd + slotname;
					proctr.transcription(proc, slotadress);
					// we add the processus to the bufferarray, to execute it a the next round robin iteration
					roundrobin.addProcRR(proc);		
				}
				else {
					scdriver.dynamicScreenadd("Slot "+ slotname +" in Disk " + hdname + " doesn't exisits, please create it and add a processus in before\n");
				}
			}
			// if the primitive is a wipe		
			if(tabinput[primitive_identifier].contains("wipe")) {
				String hdname = tabinput[2];
				String slotname = tabinput[4];
				String selectedhd =" ";
				if(hdname.contentEquals("hd1")) {
					selectedhd = "harddisks1/";
				}
				else if(hdname.contentEquals("hd2")) {
					selectedhd = "harddisks2/";
				}
				String path = "./src/"+selectedhd+slotname;
				File file = new File(path);
				if(file.exists()) {
					file.delete();
					File newfile = new File(path);
					try {
						newfile.createNewFile();
						scdriver.dynamicScreenadd("Slot "+ slotname +" in Disk " + hdname + " has been sucessfully reset\n");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					scdriver.dynamicScreenadd("Slot "+ slotname +" does not exists in HardDisk" + hdname + "\n");
				}
							
				
			}
			// else if the primitive is read
			else if(tabinput[primitive_identifier].contains("read")) {
				String slotname = tabinput[4];
				String hdname = tabinput[2];
				String selectedhd ="";
				if(hdname.contentEquals("hd1")) {
					selectedhd = "harddisks1/";
					
				}
				else if(hdname.contentEquals("hd2")) {
					selectedhd = "harddisks2/";
				}
				String result = "-------------------- content " + slotname+ " --------------------\n";
				try {
					BufferedReader read = new BufferedReader(new FileReader(HardDisks_position + selectedhd + slotname));
					String bufferread;
					while((bufferread = read.readLine()) != null) {
						result +=  "\n" + bufferread ;
					}
					read.close();
					result += "\n-------------------- end " + slotname+ " --------------------\n";
					scdriver.dynamicScreenadd(result);
				}
				catch (FileNotFoundException e) {
					scdriver.dynamicScreenadd( "ERROR : slot" + slotname +" not found, please retry\n");
				}
				catch (IOException e) {
					scdriver.dynamicScreenadd( "Error in the reading of the slot" + slotname +" , please retry\n");
				}
			}

			// else if the primitive is a addlost primitive
			else if(tabinput[primitive_identifier].contains("addslot")) {
				String hdname = tabinput[2];
				String slotname = tabinput[4];
				if(hdname.equals(hd1.getHd().getperipheralid())) {
					if(slotname.contentEquals("slot1") || slotname.contentEquals("slot2")  ||slotname.contentEquals("slot3")  ||slotname.contentEquals("slot4") ||slotname.contentEquals("slot5")) {
						if(hd1.getSlotinfo().containsKey(slotname)) {
							scdriver.dynamicScreenadd("ERROR : " + slotname + " already exists\n");
						}
						else {
							try {
								hd1.addSlot(slotname);
								scdriver.dynamicScreenadd("Slot " + slotname + " has been successfully created in HardDisk " + hdname + "\n");
							} catch (FullHDException e) {
								scdriver.dynamicScreenadd("ERROR : " + hdname + " is full, please delete a slot first\n");
							}
						}
					}
					else {
						scdriver.dynamicScreenadd("ERROR : Please use slot named \"slot[1-5]\", for example \"slot4\"  \n");
					}
				}
				else if(hdname.equals(hd2.getHd().getperipheralid())) {
					if(slotname.contentEquals("slot1") || slotname.contentEquals("slot2")  ||slotname.contentEquals("slot3")  ||slotname.contentEquals("slot4") ||slotname.contentEquals("slot5")) {
						if(hd2.getSlotinfo().containsKey(slotname)) {
							scdriver.dynamicScreenadd("ERROR : " + slotname + " already exists\n");
						}
						else {
							try {
								hd2.addSlot(slotname);
								scdriver.dynamicScreenadd("Slot " + slotname + " has been successfully created in HardDisk " + hdname + "\n");
							} catch (FullHDException e) {
								scdriver.dynamicScreenadd("ERROR : " + hdname + " is full, please delete a slot first\n");
							}						
						}
					}
					else {
						scdriver.dynamicScreenadd("ERROR : Please use slot named \"slot[1-5]\", for example \"slot4\" \n");
					}
				}
				else {
					scdriver.dynamicScreenadd("ERROR : HardDisk "+ hdname +" does not exists\n");
				}
				
			}
			// else if the primitive is a delslot primitive
			else if(tabinput[primitive_identifier].contains("delslot")) {
				String hdname = tabinput[2];
				String slotname = tabinput[4];
				if(hdname.equals(hd1.getHd().getperipheralid())) {
					if(slotname.contentEquals("slot1") || slotname.contentEquals("slot2")  ||slotname.contentEquals("slot3")  ||slotname.contentEquals("slot4") ||slotname.contentEquals("slot5")) {
						if(hd1.getHd().getSlotlist().containsKey(slotname)) {
							hd1.getHd().getSlotlist().get(slotname).delete();
						}
						else {
							scdriver.dynamicScreenadd("ERROR : Slot "+ slotname +" does not exists in HardDisk" + hdname + "\n");
						}
					}
					else {
						scdriver.dynamicScreenadd("ERROR : Please use slot named \"slot[1-5]\", for example \"slot4\" \n");
					}
				}
				else if(hdname.equals(hd2.getHd().getperipheralid())) {
					if(slotname.contentEquals("slot1") || slotname.contentEquals("slot2")  ||slotname.contentEquals("slot3")  ||slotname.contentEquals("slot4") ||slotname.contentEquals("slot5")) {
						if(hd2.getHd().getSlotlist().containsKey(slotname)) {
							hd2.getHd().getSlotlist().get(slotname).delete();
						}
						else {
							scdriver.dynamicScreenadd("ERROR : Slot "+ slotname +" does not exists in HardDisk" + hdname + "\n");
						}
					}
					else {
						scdriver.dynamicScreenadd("ERROR : Please use slot named \"slot[1-5]\", for example \"slot4\" \n");
					}
				}
				else {
					scdriver.dynamicScreenadd("ERROR : HardDisk "+ hdname +" does not exists\n");
				}
				
			}
		}
		else if (tabinput.length == 2) {
			// if the primitive is a clear
			if(tabinput[primitive_identifier].contains("clear")) {
				// we clear the screen
				scdriver.resetScreen();
			}
		}
		
		
		// else if the primitive is write
		else if(tabinput[primitive_identifier].contains("write")) {
			String slotname = tabinput[4];
			String hdname = tabinput[2];
			String stradd = "";
			for(int i=6; i < tabinput.length-1 ; i++) {
				stradd += tabinput[i] + " ";
			}
			stradd +="\n";
			if(hdname.contentEquals("hd1")) {
				File testexists = new File ("./src/harddisks1/"+slotname);
				if(testexists.exists()) {
					if(testexists.length() + stradd.length() < 2000) {
						try {
							BufferedWriter write = new BufferedWriter(new FileWriter("./src/harddisks1/"+slotname, true));
							write.write(stradd);
							write.close();
							scdriver.dynamicScreenadd("Writing operation in slot "+ slotname+" of the disk "+hdname+" has been done \n");
						} catch (IOException e) {
							scdriver.dynamicScreenadd("ERROR : Writing in slot " + slotname + " wasn't possible, please retry\n");
						}
					}
				}
				else {
					scdriver.dynamicScreenadd("ERROR : Slot " + slotname + " in Disk "+ hdname +" does not exists, please create in first\n");
				}
			}
			else if(hdname.contentEquals("hd2")) {
				File testexists = new File ("./src/harddisks2/"+slotname);
				if(testexists.exists()) {
					if(testexists.length() + stradd.length() < 2000) {
						try {
							BufferedWriter write = new BufferedWriter(new FileWriter("./src/harddisks2/"+slotname, true));
							write.write(stradd);
							write.close();
							scdriver.dynamicScreenadd("Writing primitive on the slot "+slotname+" in disk "+hdname+" has succeed\n");
						} catch (IOException e) {
							scdriver.dynamicScreenadd("ERROR : Writing in slot " + slotname + " wasn't possible, please retry\n");
						}
					}
				}
				else {
					scdriver.dynamicScreenadd("ERROR : Slot " + slotname + " in Disk "+ hdname +" does not exists, please create in first\n");
				}
			}
			else {
				scdriver.dynamicScreenadd("ERROR :  "+ hdname +" doesn't exists, please write on a existing disk \n");
			}
			
		}
		// else the primitive hasn't been recognized
		else {
			scdriver.dynamicScreenadd( "Primitive written isn't recognized, please correct it and retry\n");
		}
	}
	
	// getters and setters

	public ScreenDriver getScdriver() {
		return scdriver;
	}

	public void setScdriver(ScreenDriver scdriver) {
		this.scdriver = scdriver;
	}

	public Rrobin getRoundrobin() {
		return roundrobin;
	}

	public void setRoundrobin(Rrobin roundrobin) {
		this.roundrobin = roundrobin;
	}
	
}
