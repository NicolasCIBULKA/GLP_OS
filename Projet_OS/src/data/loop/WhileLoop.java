package data.loop;

import data.arithmeticaloperation.Comparaison;
import data.processus.Processus;

public class WhileLoop extends LoopOperation{
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
	private boolean needcheck;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public WhileLoop(Processus proc, Comparaison comparaison) {
		super(proc);
		this.setComparaison(comparaison);
		this.setNeedcheck(true);
	}
	
	// getters and setters

	public Comparaison getComparaison() {
		return comparaison;
	}

	public void setComparaison(Comparaison comparaison) {
		this.comparaison = comparaison;
	}

	public boolean isNeedcheck() {
		return needcheck;
	}

	public void setNeedcheck(boolean needcheck) {
		this.needcheck = needcheck;
	}

	
}
