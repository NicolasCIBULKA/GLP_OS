package data.processus;

import java.util.ArrayList;

import data.iftest.Ifelsetest;
import data.loop.ForLoop;
import data.loop.WhileLoop;
import process.rrobin.Variablebuffer;

public class Processus {
	
	/*
	 * This class contains all the operations of a processus in the arrayList
	 * 
	 * @Author Nicolas CIBULKA
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private ArrayList<Operation> operationlist;
	private int alreadydoneoperation;
	private int priority;
	private int pid;
	private Variablebuffer varbuffer;
	private String processusname;
	private int arrivalTime;
	private int completionTime;
	private int cpuBurst ;
	private int waitTime;
	private int responseTime;
	private int turnaroundTime;
	private int cpuBurstLeft ;
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// this is the constructor of the Processus class
	public Processus(String processusname,int pid, int aT, int cpub) {
		this.operationlist = new ArrayList<Operation>();
		this.processusname = processusname;
		this.setAlreadydoneoperation(0);
		setarrivalTime(aT);
		setpid(pid);
		setcpuBurst(cpub);
		varbuffer = new Variablebuffer();
	}
	
	
	public Processus() {
		this.operationlist = new ArrayList<Operation>();
		varbuffer = new Variablebuffer();
		this.setAlreadydoneoperation(0);
		
	}
	// Getters and setters

	public ArrayList<Operation> getOplist() {
		return operationlist;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getpid() {
		return pid;
	}
	
	public void setpid(int pid) {
		this.pid = pid;	
	}
	
	public String getProcessusname() {
		return processusname;
	}
	
	public void setProcessusname(String processusname) {
		this.processusname = processusname;
	}

	public int getNboperation() {
		// estimation of operation that left
		int result = 0;
		for(int i = 0 ; i < this.getOplist().size(); i++) {
			if(this.getOplist().get(i) instanceof ForLoop) {
				ForLoop floop = (ForLoop) this.getOplist().get(i);
				result += floop.getOperations().getProcessussize() * floop.getIternumber();
			}
			else if(this.getOplist().get(i) instanceof WhileLoop ) {
				WhileLoop whloop = (WhileLoop) this.getOplist().get(i);
				result += whloop.getOperations().getProcessussize()*(whloop.getComparaison().getA().getContent()/whloop.getComparaison().getB().getContent());
			}
			else if(this.getOplist().get(i) instanceof Ifelsetest) {
				Ifelsetest ifelsetest = (Ifelsetest) this.getOplist().get(i);
				result += (ifelsetest.getIfprocessus().getProcessussize() + ifelsetest.getElseprocessus().getProcessussize())/2;
			}
			else if(this.getOplist().get(i) instanceof Operation ) {
				result++;
			}
		}
		return result;
		/*
		cpuBurstLeft = operationlist.size();
		return operationlist.size();
		*/
	}
	
	public int getProcessussize() {
		return operationlist.size();
	}
	
	public void addOperation(Operation op) {
		operationlist.add(op);
	}
	public int getarrivalTime(){
		return arrivalTime; //get arrival time of process
	}
	
	public void setarrivalTime(int aT){
		arrivalTime = aT; //set arrival time of process
	}
	
	public int getcpuBurst(){
		return cpuBurst; //get CPU Burst of process
	}
	
	public void setcpuBurst(int cpub){
		cpuBurst = cpub; //set CPU burst of process
	}
	
	public int getcompletionTime(){
		return completionTime; //get the time when the process is finished with its CPU Burst
	}
	
	public void setcompletionTime(int cT){
		completionTime = cT; //set the time when the process is finished with its CPU Burst
	}
	
	public int getWaitTime(){
		return waitTime; //get the wait time of the process
	}
	
	public void setWaitTime(int wt){
		waitTime = wt; //set the wait time of the process
	}
		
	public int getResponseTime(){
		return responseTime; //get the response time of the process
	}
	
	public void setResponseTime(int rt){
		responseTime = rt; //set the response time of the process
	}
	
	public int getturnaroundTime(){
		return turnaroundTime;  //get the turnaround time of the process
	}
	
	public void setturnaroundTime(int tt){
		turnaroundTime = tt; //set the turnaround time of the process
	}
	
	public int getCPUBurstLeft(){
		return cpuBurstLeft; //the remaining count of CPU Burst left for a process (for RR and SRTF)
	}
	
	public void setCPUBurstLeft(int bl){
		cpuBurstLeft = bl; //set the remaining count of CPU Burst left for a process when preempted (for RR and SRTF)
	}

	public Variablebuffer getVarbuffer() {
		return this.varbuffer;
	}

	public void setVarbuffer(Variablebuffer varbuffer) {
		this.varbuffer = varbuffer;
	}

	public int getAlreadydoneoperation() {
		return alreadydoneoperation;
	}

	public void setAlreadydoneoperation(int alreadydoneoperation) {
		this.alreadydoneoperation = alreadydoneoperation;
	}
	
	public void incrementADO() {
		this.alreadydoneoperation++;
	}
	
		
}
