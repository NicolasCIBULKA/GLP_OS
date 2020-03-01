package data.loop;

import data.arithmeticaloperation.Comparaison;
import data.processus.Processus;

public class Whileloop extends LoopOperation{
	/*
	 * This is the abstract class of all the loop Operations, such
	 * 
	 * as "while" or "for"
	 * 
	 * @author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------

	private Comparaison comparaison;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Whileloop(Processus proc, Comparaison comparaison) {
		super(proc);
		this.setComparaison(comparaison);
	}
	
	// getters and setters

	public Comparaison getComparaison() {
		return comparaison;
	}

	public void setComparaison(Comparaison comparaison) {
		this.comparaison = comparaison;
	}

	
}
