package process.rrobin;

import java.util.ArrayList;


import data.drivers.ScreenDriver;
import data.processus.*;
import org.apache.log4j.Logger;
import logs.LoggerUtility;

public class Rrobin extends Thread implements Runnable{
	/*
	 * This class implement Round Robin algorithm, to simulate the Processor
	 * 
	 * @author Nicolas CIBULKA
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private static int quantum = 10; // Define the period of the inner clock
	
	private static Logger logger = LoggerUtility.getLogger(Rrobin.class, "text");

	private Processuslist plist;
	private int bursttime = 1;
	private Processuslist buffer;
	private ScreenDriver scdriver;
	private OperationExec executor;
	private int activeprocposition;
	private int CPUUsing;
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// Constructor 
	public Rrobin(Processuslist plist, ScreenDriver scdriver) {
		this.setPlist(plist);
		buffer = new Processuslist();
		this.setScdriver(scdriver);
		this.executor = new OperationExec();
	}
	
	@Override
	public void run() {
		do {
			this.RrobinUnit();
			
		}while(this.getPlist().getProcessuslist().size() > 0);
	}
	
	// Round robin unit that will be in the thread, and executed before actualising the screen content
	public void RrobinUnit() {
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
			logger.info("Round robin  - Processus " + processusindice + " on " + this.getPlist().getProcessuslist().size());
			Processus activeproc = this.getPlist().getProcessuslist().get(processusindice);
			this.setCPUUsing(activeproc.getOplist().get(activeproc.getAlreadydoneoperation()).getCpuusing());
			logger.info("Round Ribon - Processus : CPU using is a " + this.getCPUUsing() + "%");
			setActiveprocposition(processusindice);
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
						Thread.sleep(1);
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
	public void SRTF(){
		//set the shortest process as the current process
		Processuslist srtf = new Processuslist();
		//if the RQ is of size 1, the shortest process will be at the head of the RQ
		
		
		{
			int j = this.getPlist().getProcessuslist().size();
			for(int v=0;v<j;v++) {
			Processus shortestProcess = this.getPlist().getProcessuslist().get(0) ;
			//if the RQ size is >1, loop through all the processes currently in the RQ and find the process
			//with the smallest CPU Burst. Set that process as the shortest process and set the response time for that process
			for(int i=0; i<this.getPlist().getProcessuslist().size(); i++){
				
				if(this.getPlist().getProcessuslist().size() == 1){
					break;
				}
				if(this.getPlist().getProcessuslist().get(i).getCPUBurstLeft() < shortestProcess.getCPUBurstLeft()){
					shortestProcess = this.getPlist().getProcessuslist().get(i);
					
					//find the position in the RQ of the shortest proces
											
				}
				
				
			 }//end for loop
			srtf.getProcessuslist().add(shortestProcess);
			this.getPlist().getProcessuslist().remove(0);
			
			}
			this.setPlist(srtf);
		//end else
		}
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
		this.getBuffer().getProcessuslist().add(proc);
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

	public int getCPUUsing() {
		return CPUUsing;
	}

	public void setCPUUsing(int cPUUsing) {
		CPUUsing = cPUUsing;
	}

	public ScreenDriver getScdriver() {
		return scdriver;
	}

	public void setScdriver(ScreenDriver scdriver) {
		this.scdriver = scdriver;
	}

	public int getActiveprocposition() {
		return activeprocposition;
	}

	public void setActiveprocposition(int activeprocposition) {
		this.activeprocposition = activeprocposition;
	}
	
	
	
}