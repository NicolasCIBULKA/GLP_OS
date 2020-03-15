package process.traduction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import data.drivers.*;
import data.processus.Processus;
import process.rrobin.Rrobin;

public class Primitivetranscriptor {
	
	/*
	 *  This is the class that will translate a primitive that come from the keyboard to a program to do
	 *  
	 *  @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Constant
	// --------------------------------------
	
	private static int primitive_identifier = 0;
	private static String HardDisks_position = "/home/nico/Bureau/Fac/L2/S2/GLP/GLP_OS/GLP_OS/Projet_OS/src/scripts/";
	
	// --------------------------------------
	// Attributs
	// --------------------------------------

	private ScreenDriver scdriver;
	private Rrobin roundrobin;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Primitivetranscriptor( Rrobin roundrobin) {
		//this.setScdriver(scdriver);
		this.setRoundrobin(roundrobin);
	}
	
	// transcription method
	
	public void transcriptor(String input, ScreenDriver scdriver) {
		// we split the input in a tab to manipulate it
		String[] tabinput = input.split(" ");
		if(tabinput.length == 4) {
			// if the primitive is a forkexec
			if(tabinput[primitive_identifier].contains("forkexec")) {
				// we translate the file into a processus
				Transcriptor proctr = new Transcriptor();
				Processus proc = new Processus();
				String slotname = tabinput[2];
				// we need to test before adding slot (doing it when the HD is ready)
				String slotadress = HardDisks_position + slotname + ".txt";
				proctr.transcription(proc, slotadress);
				// we add the processus to the bufferarray, to execute it a the next round robin iteration
				roundrobin.addProcRR(proc);
			}
			
			// else if the primitive is read
			else if(tabinput[primitive_identifier].contains("read")) {
				String slotname = tabinput[2];
				String result = "-------------------- content " + slotname+ " --------------------\n";
				try {
					BufferedReader read = new BufferedReader(new FileReader(HardDisks_position + slotname + ".txt"));
					String bufferread;
					while((bufferread = read.readLine()) != null) {
						result +=  "\n" + bufferread ;
					}
					read.close();
					result += "\n-------------------- end " + slotname+ " --------------------\n";
					this.dynamicScreenadd(scdriver, result);
				}
				catch (FileNotFoundException e) {
					this.dynamicScreenadd(scdriver, "slot" + slotname +" not found, please retry\n");
				}
				catch (IOException e) {
					this.dynamicScreenadd(scdriver, "Error in the reading of the slot" + slotname +" , please retry\n");
				}
			}
			// else if the primitive is write
			else if(tabinput[primitive_identifier].contains("write")) {
				
			}
		}
		else if (tabinput.length == 2) {
			// if the primitive is a clear
			if(tabinput[primitive_identifier].contains("clear")) {
				// we clear the screen
				scdriver.resetScreen();
			}
		}
		else if(tabinput.length == 6){
			// if the primitive is a wipe
			if(tabinput[primitive_identifier].contains("wipe")) {
				String slotname = tabinput[2];
			}
			// else if the primitive is a addlost primitive
			else if(tabinput[primitive_identifier].contains("addslost")) {
				
			}
			// else if the primitive is a delslot primitive
			else if(tabinput[primitive_identifier].contains("delslot")) {
				
			}
			// else if the primitive is a nice primitive
			else if(tabinput[primitive_identifier].contains("nice")) {
				
			}
		}
		else if(tabinput.length == 4) {
			if(tabinput[primitive_identifier].contains("read")) {
				
			}
		}
		else if(tabinput[primitive_identifier].contains("write")) {
			
		}
		// else the primitive hasn't been recognized
		else {
			this.dynamicScreenadd(scdriver, "Primitive written isn't recognized, please correct it and retry\n");
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
	
	public void dynamicScreenadd(ScreenDriver scdriver, String scadd) {
		String content;
		content = scdriver.getScreencontent();
		scdriver.resetScreen();
		scdriver.addStringScreen(content + scadd);
	}
	
}
