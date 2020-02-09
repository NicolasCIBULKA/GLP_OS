package data.processus;

public class Nice {

	private int priority; // between -20 for the highest priority and +19 for the lowest
	
	

	public Nice(int priority) throws IllegalArgumentException {
		if((priority < -20) || (priority > 19)) {
			throw new IllegalArgumentException();
		}
		else {
		this.priority = priority;
		}
	}
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if((priority < -20) || (priority > 19)) {
			throw new IllegalArgumentException();
		}
		else {
		this.priority = priority;
		}
	}

}
