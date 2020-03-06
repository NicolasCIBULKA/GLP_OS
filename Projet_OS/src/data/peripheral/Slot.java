package data.peripheral;

public class Slot {

	private int size = 2000; // 2000 characters
	private String content;
		
	
	public Slot(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
