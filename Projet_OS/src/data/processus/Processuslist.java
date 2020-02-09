package data.processus;

import java.util.ArrayList;

public class Processuslist {
	/*
	 * This is the class that agregates all the processus, and will be used for Roud robin treatment 
	 * 
	 * @Author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Processus> Processuslist;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor of the Processuslist class
	
	public void setProcessuslist(ArrayList<Processus> processuslist) {
		Processuslist = processuslist;
	}
	
	// getters and setters 
	public Processuslist() {
		this.setProcessuslist(new ArrayList<Processus>());
	}

	public ArrayList<Processus> getProcessuslist() {
		return Processuslist;
	}

	
	
	
}
