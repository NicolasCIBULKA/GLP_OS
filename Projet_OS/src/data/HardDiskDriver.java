package data;

public class HardDiskDriver extends Driver{

	private HardDisk hd;
	
	public HardDiskDriver(String driverID, Interaction authorization, String linkperipheral) {
		super(driverID, authorization);
		hd.setperipheralid(linkperipheral);
	}
	
	public void hardDiskWrite(String text){
		checkMaxChar(text);
		hd.setContent(text);
	}
	
	public void hardDiskRead() {
		hd.getContent();
		
	}
	public void checkMaxChar(String text) {
		int max = hd.getMaxCharacters();
		int usedspace = hd.getUsedSpace();
		
		if((usedspace + text.length()) >= max) {
			hd.setCanAddContent(false);
		}
		else {
			hd.setCanAddContent(true);
		}
	}

}
