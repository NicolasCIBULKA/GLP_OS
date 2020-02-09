package data.processus;

public class Sleep {

	private int quantum = 10; //  quantum of 10ms for now
	
	public Sleep(int time) throws InterruptedException {
		Thread.sleep(time);
		
	}
	public void sleepRoundRobin() throws InterruptedException {
		Thread.sleep(quantum);
	}
	
	public int getQuantum() {
		return quantum;
	}
	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

}
