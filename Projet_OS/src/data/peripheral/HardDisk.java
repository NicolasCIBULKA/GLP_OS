package data.peripheral;


public class HardDisk extends Peripheral {
	
	
	int maxCharacters; // Maximum capacity in number of characters
	String content;
	int usedSpace; // Space used in number of characters
	boolean isRunning;
	boolean canAddContent;

	public HardDisk(int maxCharacters, String peripheralid) {
		super(peripheralid);
		this.maxCharacters = maxCharacters;
		isRunning = true;
		content = "";
		usedSpace = 0;
		canAddContent = true;
		
		
	}

	public boolean isCanAddContent() {
		return canAddContent;
	}

	public void setCanAddContent(boolean canAddContent) {
		this.canAddContent = canAddContent;
	}

	public int getMaxCharacters() {
		return maxCharacters;
	}

	public void setMaxCharacters(int maxCharacters) {
		this.maxCharacters = maxCharacters;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(int usedSpace) {
		this.usedSpace = usedSpace;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	

}
