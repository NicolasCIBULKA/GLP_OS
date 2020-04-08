package process.traduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.drivers.*;
import data.primitive.Primitive;
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
	private static String HardDisks_position = "	";
	
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
					scdriver.dynamicScreenadd( result);
				}
				catch (FileNotFoundException e) {
					scdriver.dynamicScreenadd( "slot" + slotname +" not found, please retry\n");
				}
				catch (IOException e) {
					scdriver.dynamicScreenadd( "Error in the reading of the slot" + slotname +" , please retry\n");
				}
			}
			// else if the primitive is write
			else if(tabinput[primitive_identifier].contains("write")) {
				String slotname = tabinput[2];
				
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
				String slotname = tabinput[2];
				String fileposition =  HardDisks_position + slotname + ".txt";
				File file = new File(fileposition);
				if(file.exists()) {
					file.delete();
					// A COMPLETER - SUPPRIMER LIEN DANS LE DD
					scdriver.dynamicScreenadd("Slot " + slotname +" has been sucessfully wiped");
				}
				else {
					scdriver.dynamicScreenadd("ERROR : slot " + slotname + " does not exists");
				}
				
			}
			// else if the primitive is a nice primitive
			else if(tabinput[primitive_identifier].contains("nice")) {
				
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
