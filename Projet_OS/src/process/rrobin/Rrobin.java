package process.rrobin;

import data.drivers.ScreenDriver;
import data.processus.*;

public class Rrobin {
	/*
	 * This class implement Round Robin algorithm, to simulate the Processor
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private static int quantum = 10; // Define the period of the inner clock
	
	private Processuslist plist;
	private int bursttime = 1;
	private Processuslist buffer;
	private ScreenDriver scdriver;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor 
	public Rrobin(Processuslist plist, ScreenDriver scdriver) {
		this.setPlist(plist);
		buffer = new Processuslist();
		this.setScdriver(scdriver);
	}
	
	// Round robin algorithm
	public void Roundrobin() {
		OperationExec executor = new OperationExec();
		// while there is something in the Processuslist
		do{
			//int indice = 0;
			// We add the possible processus that we launched during a RR tour
			if(this.getBuffer().getProcessuslist().size() > 0) {
				for(int i = 0; i < buffer.getProcessuslist().size(); i++) {
					this.getPlist().getProcessuslist().add(this.getBuffer().getProcessuslist().get(i));
				}
				// we clear the buffer
				this.getBuffer().getProcessuslist().clear();
			}
			// Starting the loop to execute a part of all processus in the plist
			for(int processusindice = 0; processusindice < this.getPlist().getProcessuslist().size(); processusindice++) {
				// taking a processus
				Processus activeproc = this.getPlist().getProcessuslist().get(processusindice);
				//System.out.println(activeproc.getProcessusname());
				// Testing if the processus is almost finished
				
				if(activeproc.getAlreadydoneoperation() + this.bursttime < activeproc.getProcessussize()) {
					// if not, executing only the number of operation that the quantum define
					// executing the number of operation that the quantum has defined
					int indice = 0;
					while(indice < this.bursttime){
						//System.out.println("oui");
						int opindice = activeproc.getAlreadydoneoperation();
						executor.operationexecution(activeproc, activeproc.getOplist().get(opindice), scdriver);
						// Sleep until a new clock iteration
						try {
							Thread.sleep(quantum);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						indice++;
					}
				}
				else {
					// if the processus is almost finished, do all the operation that last
					while(activeproc.getAlreadydoneoperation() < activeproc.getProcessussize()) {
						executor.operationexecution(activeproc, activeproc.getOplist().get(activeproc.getAlreadydoneoperation()), scdriver);
						// Sleep until a new clock iteration
						try {
							Thread.sleep(quantum);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if(activeproc.getAlreadydoneoperation() == activeproc.getProcessussize()) {
					plist.getProcessuslist().remove(activeproc);
				}
			}
		} while(this.getPlist().getProcessuslist().size() > 0);
	}
	
	// Getters and setters	
	
	public int getBursttime() {
		return bursttime;
	}

	public void setBursttime(int bursttime) {
		this.bursttime = bursttime;
	}

	public Processuslist getPlist() {
		return plist;
	}

	public void setPlist(Processuslist plist) {
		this.plist = plist;
	}
	
	public void addProcRR(Processus proc) {
		this.getPlist().getProcessuslist().add(proc);
	}
	
	public void removeProcRR(Processus proc) {
		this.getBuffer().getProcessuslist().remove(proc);
	}

	public Processuslist getBuffer() {
		return buffer;
	}

	public void setBuffer(Processuslist buffer) {
		this.buffer = buffer;
	}

	public ScreenDriver getScdriver() {
		return scdriver;
	}

	public void setScdriver(ScreenDriver scdriver) {
		this.scdriver = scdriver;
	}
	
	
	
}
