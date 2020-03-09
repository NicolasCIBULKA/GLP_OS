package process.rrobin;

import java.util.ArrayList;
import data.processus.*;

public class RoundRobin2 extends Scheduler {
	private int systemCount;
	private int idleCount;

	public RoundRobin2(){
		super(); //class parent class Scheduler
		systemCount = 0; //set time in system to 0
		idleCount = 0; //counter for time no process is allocated the cpu
	}
	
	
	public void runRR(ArrayList<Processus> processus, int Quantum){
		double avgCPUU;
		double avgWT;
		double avgRT;
		double avgTT;
		System.out.println();
		System.out.println("Scheduling Algorithm: Round Robin");
		System.out.println("=========================================================");
		
		roundRobin(processus, Quantum); //runs the round robin algorithm
		
		//calculate averages
		avgCPUU = averageCPUUsage(); //calculates average CPU Usage
		avgWT = averageWaitTime(processus); //calculates average Wait Time
		avgRT = averageResponseTime(processus); //calculates average Response Time
		avgTT = averageTurnaroundTime(processus); //calculates average Turnaround Time
		
		System.out.println("<system time   " + systemCount + "> All processes finished...");
		System.out.println("=========================================================");
		System.out.print("Average CPU usage: ");
			System.out.printf("%.2f", avgCPUU);	
			System.out.println("%");
		System.out.print("Average waiting time: ");
			System.out.printf("%.2f", avgWT);
			System.out.println();
		System.out.print("Average response time: ");
			System.out.printf("%.2f", avgRT);
			System.out.println();
		System.out.print("Average turnaround time: ");
			System.out.printf("%.2f", avgTT);
			System.out.println();
		System.out.println("=========================================================");
	}
	
	public void roundRobin(ArrayList<Processus> processus, int quantum){
		int totalProcesses = processus.size(); //will store the number of distinct processes that will be allocated the cpu
		int process=0; //first process to arrive
		Processus currProcess;
		
		//loop will continue if the first process that will be put in the Ready Queue arrives at a time later than 0
		while(processus.get(process).getarrivalTime() != systemCount){
			System.out.println("<system time   " + systemCount + "> idle");
			idleCount++;
			systemCount++;
		}
		
		super.addProcess(processus.get(process)); //add the process to the Ready Queue
		process++; //increment to next job that will arrive
		currProcess = super.getProcess(0); //set current process to the first process in the ReadyQueue
		currProcess.setResponseTime(systemCount - currProcess.getarrivalTime()); //set the ResponseTime
		// while loop to check if multiple processes have the same arrival time
		while((process != totalProcesses) && (processus.get(process).getarrivalTime() == systemCount)){ 
			super.addProcess(processus.get(process)); //add process to the ReadyQueue
			process++; //increment to next job that will arrive
		}
		//outer while loop will keep looping until a condition is met (all processes have completed their cpu burst)
		while(true){
			//this loop will check if the Ready Queue is empty BUT there are still processes 
			//in the process pool that still need to arrive to be placed in the ReadyQueue
			while((process != totalProcesses) && super.readyQueueEmpty()){
				if(processus.get(process).getarrivalTime() == systemCount){
					super.addProcess(processus.get(process)); //add the process to the Ready Queue 
					currProcess = super.getProcess(0); //since the RQ was empty, this is now the process at the head of the RQ
					currProcess.setResponseTime(systemCount - currProcess.getarrivalTime());
					process++;
					break; 
				}
				else{
					//if no process arrives, cpu is in idle
					System.out.println("<system time   " + systemCount + "> idle");
					idleCount++;
					systemCount++;
				}
			}
			//for loop will depend on the Time Quantum 
			for(int i=0; i<quantum; i++){	
				//if the process has not completed it cpu burst, it should run
				currProcess = SRTF(currProcess);//Shortest remaining time first
				//currProcess = LRTF(currProcess); //Longest remaining time first
				if(currProcess.getCPUBurstLeft() != 0){
					System.out.println("<system time   " + systemCount + "> process    " + currProcess.getpid() +" is running" );
					systemCount++;
					//update the amount of cpu burst is left for the process
					currProcess.setCPUBurstLeft(currProcess.getCPUBurstLeft()-1);
					
					// while loop to check if multiple processes have the same arrival time, check for any new processes
					while((process != totalProcesses) && (processus.get(process).getarrivalTime() == systemCount)){
						super.addProcess(processus.get(process));
						process++;
					}
					//if process has completed its cpu burst
					if(currProcess.getCPUBurstLeft() == 0){
						currProcess.setcompletionTime(systemCount); //set complete time of process
						currProcess.setturnaroundTime(currProcess.getcompletionTime() - currProcess.getarrivalTime()); //set turnaround time
						currProcess.setWaitTime(currProcess.getcompletionTime() - (currProcess.getarrivalTime() + currProcess.getcpuBurst())); //set wait time
						System.out.println("<system time   " + systemCount + "> process    " + currProcess.getpid() +" is finished....." );
						break; //break from for loop since process does not need to complete quantum
					}
				}
			}// end for loop
			
			if(!super.readyQueueEmpty()){
				//if there are multiple processes in the readyQueue, when the quantum is completed, one process switches to another
				//this would inform when the switch occurs and with which processes
				if(super.readyQueueSize() > 1){
					System.out.println("<system time   " + systemCount + "> switching from process " + currProcess.getpid() + " to process " +super.getProcess(1).getpid());
				}
				//if current process if complete, remove the process from the RQ
				if(currProcess.getCPUBurstLeft() == 0){
					super.removeProcess(0);
					//if RQ is not empty, get the next process currently at the head of the Q
					if(!super.readyQueueEmpty()){
						currProcess = super.getProcess(0);
						if(currProcess.getCPUBurstLeft() == currProcess.getcpuBurst()){
							currProcess.setResponseTime(systemCount - currProcess.getarrivalTime());
						}
					}
				}
				else{
					//if no process was removed, rotate the current process at the head of the RQ to the end of the RQ
					super.rotateReadyQueue();
					currProcess = super.getProcess(0);
					//if this is the first time this process is running, set the response time for that process
					if(currProcess.getCPUBurstLeft() == currProcess.getcpuBurst()){
						currProcess.setResponseTime(systemCount - currProcess.getarrivalTime());
					}
				}					
			}
			//if the ready queue is empty and all processes have completed its cpu burst, break out of out while loop
			else if(super.readyQueueEmpty() && process == totalProcesses){
				break;
			}
		} //end while loop
	} //end rr method
	
	//calculate average CPU Usage
	private double averageCPUUsage(){
		double avgCPUU = ((double)(systemCount-idleCount)/systemCount);
		return (100.0*avgCPUU);
	}
	
	//calculate average Wait Time
	private double averageWaitTime(ArrayList<Processus> processus){
		int sum=0;
		double avgWT = 0.0;
		for(int i=0; i<processus.size(); i++){
			sum = sum + processus.get(i).getWaitTime();
		}
		avgWT = (double)sum / processus.size();
		return avgWT;
	}
	
	//calculate average Response Time
	private double averageResponseTime(ArrayList<Processus> processus){
		int sum=0;
		double avgRT = 0.0;
		for(int i=0; i<processus.size(); i++){
			sum = sum + processus.get(i).getResponseTime();
		}
		avgRT = (double)sum / processus.size();
		return Math.round(avgRT);
	}
	
	//calculate average Turnaround Time
	private double averageTurnaroundTime(ArrayList<Processus> processus){
		int sum=0;
		double avgTT = 0.0;
		for(int i=0; i<processus.size(); i++){
			sum = sum + processus.get(i).getturnaroundTime();
		}
		avgTT = (double)sum / processus.size();
		return avgTT;
	}



	
	
	public Processus SRTF(Processus currProcess){
		Processus shortestProcess = currProcess; //set the shortest process as the current process
		
		//if the RQ is of size 1, the shortest process will be at the head of the RQ
		if(super.readyQueueSize() == 1){
			
			//if this is the first time the process is allocated the CPU, set the response time
			if(shortestProcess.getCPUBurstLeft() == shortestProcess.getcpuBurst()){
				shortestProcess.setResponseTime(systemCount - shortestProcess.getarrivalTime());
			}
		}
		
		else{ 
			//if the RQ size is >1, loop through all the processes currently in the RQ and find the process
			//with the smallest CPU Burst. Set that process as the shortest process and set the response time for that process
			for(int i=0; i<super.readyQueueSize(); i++){
				if(super.getProcess(i).getCPUBurstLeft() < shortestProcess.getCPUBurstLeft()){
					shortestProcess = super.getProcess(i);
					//find the position in the RQ of the shortest process
					
					if(shortestProcess.getCPUBurstLeft() == shortestProcess.getcpuBurst()){
						shortestProcess.setResponseTime(systemCount - shortestProcess.getarrivalTime());
					}							
				}
			 }//end for loop
		}//end else
		return shortestProcess;
}
	public Processus LRTF(Processus currProcess){
		Processus longestProcess = currProcess; //set the longest process as the current process
		
		//if the RQ is of size 1, the longest process will be at the head of the RQ
		if(super.readyQueueSize() == 1){
			
			//if this is the first time the process is allocated the CPU, set the response time
			if(longestProcess.getCPUBurstLeft() == longestProcess.getcpuBurst()){
				longestProcess.setResponseTime(systemCount - longestProcess.getarrivalTime());
			}
		}
		
		else{ 
			//if the RQ size is >1, loop through all the processes currently in the RQ and find the process
			//with the longuest CPU Burst. Set that process as the longuest process and set the response time for that process
			for(int i=0; i<super.readyQueueSize(); i++){
				if(super.getProcess(i).getCPUBurstLeft() > longestProcess.getCPUBurstLeft()){
					longestProcess = super.getProcess(i);
					//find the position in the RQ of the longuest process
					
					if(longestProcess.getCPUBurstLeft() == longestProcess.getcpuBurst()){
						longestProcess.setResponseTime(systemCount - longestProcess.getarrivalTime());
					}							
				}
			 }//end for loop
		}//end else
		return longestProcess;
}
}



