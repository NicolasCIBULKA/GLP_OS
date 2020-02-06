package data.processus;

import java.util.ArrayList;

public class Processuslist {
	/*
	 * This is the class that agregates all the processus, and will be used for Roud robin treatment 
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Processus> Processuslist;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the Processuslist class
	public Processuslist() {
		this.setProcessuslist(new ArrayList<Processus>());
	}

	// getters and setters
	public ArrayList<Processus> getProcessuslist() {
		return Processuslist;
	}

	public void setProcessuslist(ArrayList<Processus> processuslist) {
		Processuslist = processuslist;
	}
	
	
	
	
}
