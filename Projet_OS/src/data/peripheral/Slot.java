package data.peripheral;

public class Slot {

	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	private String slotposition;
	private int size;
	
	private static String fileposition = "../harddisks";
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	public Slot(String name) {
		this.setSize(0);
		this.setSlotposition(fileposition + name);
	}
	
	// getters and setters
	
	public String getSlotposition() {
		return slotposition;
	}
	
	public void setSlotposition(String slotposition) {
		this.slotposition = slotposition;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public void setContent(String text) {
		// TODO Auto-generated method stub
		
	}

	public void getContent() {
		// TODO Auto-generated method stub
		
	}
	
}
