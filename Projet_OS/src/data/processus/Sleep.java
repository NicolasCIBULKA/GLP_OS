package data.processus;

public class Sleep extends ProcessusControl {
	
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int time; // time in ms
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	public Sleep(Processus processus, int time) {
		super(processus);
		this.setTime(time);
	}
	
	public Sleep(Processus processus) {
		super(processus);
		this.setTime(1000);
	}
	/*
	public void sleepRoundRobin()  {
		Thread.sleep(quantum);
	}
	
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	 */
	
	// getters and setters
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	// toString 
	public String toString() {
		return "Processus : " + this.getProcessus().getProcessusname() + " -  PID : " + this.getProcessus().getpid() + " - has been sleeped for " + this.getTime() + "ms" ;

	}

	
}
