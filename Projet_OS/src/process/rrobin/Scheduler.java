package process.rrobin;

import java.util.ArrayList;
import java.util.List;
import data.processus.*;

public class Scheduler {
	private List<Processus> readyQueue;

	
	public List<Processus> getReadyQueue() {
		return readyQueue;
	}

	public void setReadyQueue(List<Processus> readyQueue) {
		this.readyQueue = readyQueue;
	}

	public Scheduler() {
		readyQueue = new ArrayList<Processus>();
	}
	
	//add a process to the ready queue
	public void addProcess(Processus p){
		readyQueue.add(p); 
	}
	
	//remove a process from the ready queue
	public void removeProcess(int p){
		readyQueue.remove(p); 
	}
	
	//get a process from a specific position in the ready queue
	public Processus getProcess(int p){
		return readyQueue.get(p); 
	}
	
	//check if the ready queue is empty
	public boolean readyQueueEmpty(){
		return readyQueue.isEmpty(); 
	}
	
	//get the size of the ready queue
	public int readyQueueSize(){
		return readyQueue.size(); 
	}
	
	//rotate the process at the top of the ready queue to the back of the ready queue
	public void rotateReadyQueue(){  
		Processus temp = readyQueue.get(0);
		readyQueue.remove(0);
		readyQueue.add(temp);
		
	}
	
	//get the position of a process in the ready queue
	public int getShortestProcessIndex(Processus p){
		return readyQueue.indexOf(p);  
	}

}
