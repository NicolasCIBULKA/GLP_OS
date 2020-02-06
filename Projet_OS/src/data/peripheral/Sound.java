package data.peripheral;

public class Sound {
	/*
	 * This class is the sound class
	 * 
	 */
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	private int volume; // actual volume of the speaker
	private int maxvolume; // Max volume of the speaker
	private boolean state; // true if it's on, false if it's off

	// --------------------------------------
	// Methods
	// --------------------------------------
	
	// This is the constructor of the class Sound
	public Sound() {
		this.setVolume(50);
		this.setMaxvolume(100);
		this.setState(true);
	}
	
	// getters and setters
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if(volume < this.getMaxvolume()) {
			this.volume = volume;
		}
	}

	public int getMaxvolume() {
		return maxvolume;
	}

	private void setMaxvolume(int maxvolume) {
		this.maxvolume = maxvolume;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
