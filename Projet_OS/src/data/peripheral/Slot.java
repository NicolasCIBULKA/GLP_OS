package data.peripheral;

import data.processus.*;
import data.primitive;

public class Slot {

	private int size;
	private Processus processus;
	
	
	public Slot(int size,Processus processus) {
		this.size = size;
		this.processus = processus;
		
			
	}
	
	public void eraseSlot(Slot slot) {
		slot.processus.kill();
		slot.size = 0;
		
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Processus getProcessus() {
		return processus;
	}
	public void setProcessus(Processus processus) {
		this.processus = processus;
	}
	

}
