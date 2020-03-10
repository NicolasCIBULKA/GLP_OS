package process.rrobin;

import java.util.ArrayList;
import data.drivers.ScreenDriver;
import data.functions.Sleep;
import data.processus.*;

public class RoundRobin2 extends Scheduler {
	private  ScreenDriver scdriver;
	private int sleeptime = 10;
	public RoundRobin2(ScreenDriver scdriver){
		super(); //class parent class Scheduler

		this.scdriver = scdriver;
	}
	
	
	public void runRR(ArrayList<Processus> processus, int Quantum){
		
		System.out.println();
		System.out.println("Scheduling Algorithm: Round Robin");
		System.out.println("=========================================================");
		
		try {
			roundRobin(processus, Quantum, scdriver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //runs the round robin algorithm
		
		
		System.out.println("All processes finished...");
		System.out.println("=========================================================");
	}
	
	public void roundRobin(ArrayList<Processus> processus, int quantum, ScreenDriver scdriver) throws InterruptedException{
		int totalProcesses = processus.size(); //will store the number of distinct processes that will be allocated the cpu
		int process=0; //first process to arrive
		Processus currProcess;
		OperationExec ope = new OperationExec();
		
		
		super.addProcess(processus.get(process)); //add the process to the Ready Queue
		process++; //increment to next job that will arrive
		currProcess = super.getProcess(0); //set current process to the first process in the ReadyQueue
		
		// while loop to check if multiple processes have the same arrival time
		while((process != totalProcesses)){ 
			super.addProcess(processus.get(process)); //add process to the ReadyQueue
			process++; //increment to next job that will arrive
		}
		//outer while loop will keep looping until a condition is met (all processes have completed their cpu burst)
		while(true){
			
			//Shorstest remaining time first
			//this loop will check if the Ready Queue is empty BUT there are still processes 
			//in the process pool that still need to arrive to be placed in the ReadyQueue
			while((process != totalProcesses) && super.readyQueueEmpty()){
				
					super.addProcess(processus.get(process)); //add the process to the Ready Queue 
					currProcess = super.getProcess(0); //since the RQ was empty, this is now the process at the head of the RQ
					//currProcess.setResponseTime(systemCount);
					process++;
					
				
				
			}
			 
				
				//if the process has not completed it cpu burst, it should run
				currProcess = SRTF(currProcess);//Shortest remaining time first

				//currProcess = LRTF(currProcess); //Longest remaining time first
				if(currProcess.getNboperation() != currProcess.getAlreadydoneoperation()){
					System.out.println(currProcess.getProcessusname() +" is running" );
					
					ope.operationexecution(currProcess, currProcess.getOplist().get(0),scdriver );
					//System.out.println(scdriver.getScreencontent());
					
					
				
					//if process has completed its cpu burst
					if(currProcess.getNboperation() == currProcess.getAlreadydoneoperation()){
						 
						currProcess.setturnaroundTime(currProcess.getcompletionTime() ); //set turnaround time
						currProcess.setWaitTime(currProcess.getcompletionTime() -  currProcess.getcpuBurst()); //set wait time
						System.out.println(" process    " + currProcess.getProcessusname() +" is finished....." );
						break; //break from for loop since process does not need to complete quantum
					}
				
			}// end for loop
			
			Thread.sleep(sleeptime);
			System.out.println("Sleeping during "+sleeptime+" ms");
			if(!super.readyQueueEmpty()){
				//if there are multiple processes in the readyQueue, when the quantum is completed, one process switches to another
				//this would inform when the switch occurs and with which processes
				if(super.readyQueueSize() > 1){
					System.out.println(" switching from process " + currProcess.getProcessusname() + " to process " +SRTF(currProcess).getProcessusname());
				}
				//if current process is complete, remove the process from the RQ
				if(currProcess.getNboperation() == currProcess.getAlreadydoneoperation()){
					super.removeProcess(0);
					//if RQ is not empty, get the next process currently at the head of the Q
					if(!super.readyQueueEmpty()){
						currProcess = super.getProcess(0);
						
					}
				}
				else{
					//if no process was removed, rotate the current process at the head of the RQ to the end of the RQ
					super.rotateReadyQueue();
					currProcess = super.getProcess(0);
					//if this is the first time this process is running, set the response time for that process
					
					
				}					
			}
			currProcess = SRTF(currProcess);
			//if the ready queue is empty and all processes have completed its cpu burst, break out of out while loop
			 if(super.readyQueueEmpty() && process == totalProcesses){
				break;
			}
		} currProcess = SRTF(currProcess);//end while loop
	} //end rr method
	
	


	
	
	public Processus SRTF(Processus currProcess){
		Processus shortestProcess = currProcess; //set the shortest process as the current process
		
		//if the RQ is of size 1, the shortest process will be at the head of the RQ
		if(super.readyQueueSize() == 1){
			
			
		}
		
		else{ 
			//if the RQ size is >1, loop through all the processes currently in the RQ and find the process
			//with the smallest CPU Burst. Set that process as the shortest process and set the response time for that process
			for(int i=0; i<super.readyQueueSize(); i++){
				if(super.getProcess(i).getCPUBurstLeft() < shortestProcess.getCPUBurstLeft()){
					shortestProcess = super.getProcess(i);
					//find the position in the RQ of the shortest process
					
											
				}
			 }//end for loop
		}//end else
		return shortestProcess;
}
	public Processus LRTF(Processus currProcess){
		Processus longestProcess = currProcess; //set the longest process as the current process
		
		//if the RQ is of size 1, the longest process will be at the head of the RQ
		if(super.readyQueueSize() == 1){
			
			
		}
		
		else{ 
			//if the RQ size is >1, loop through all the processes currently in the RQ and find the process
			//with the longuest CPU Burst. Set that process as the longuest process and set the response time for that process
			for(int i=0; i<super.readyQueueSize(); i++){
				if(super.getProcess(i).getCPUBurstLeft() > longestProcess.getCPUBurstLeft()){
					longestProcess = super.getProcess(i);
					//find the position in the RQ of the longuest process					
				}
			 }//end for loop
		}//end else
		return longestProcess;
}
}



