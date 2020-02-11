package data.peripheral;

import data.processus.*;

public class Slot {

	private int size = 2000; // 2000 characters
	private String content;
	
	private Processus processus;
	
	
	public Slot(int size,Processus processus) {
		this.size = size;
		this.processus = processus;	
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
