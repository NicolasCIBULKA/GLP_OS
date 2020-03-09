package data.drivers;

import data.peripheral.HardDisk;
import data.peripheral.Slot;

public class HardDiskDriver extends Driver{

	private HardDisk hd;
	
	public HardDiskDriver(String driverID, Interaction authorization, String linkperipheral) {
		super(driverID, authorization);
		hd.setperipheralid(linkperipheral);
	}
	
	public void hardDiskWrite(String text,int slotnumber){
		Slot slot = hd.getSlotlist().get(slotnumber);
		try {
			checkFullHD(text);
		} catch (FullHDException e) {
			e.printStackTrace();
		}
		int sizeSlot = slot.getSize();
		int sizeText = text.length();
		slot.setSize(sizeSlot - sizeText );
		slot.setContent(text);
	
	}
	
	public void hardDiskRead(int slotnumber) {
		Slot slot = hd.getSlotlist().get(slotnumber);
		slot.getContent();
		
	}
	public void checkFullHD(String text) throws FullHDException {
		int maxslot = hd.getSlotnumber() * 2000;
		int i;
		Slot slot;
		int usedSpace = 0;
		for(i=0;i<maxslot;i++) {
			 slot = hd.getSlotlist().get(i); 
			 usedSpace = usedSpace + slot.getSize();
			
		}
		
		if((usedSpace) >= maxslot) {
			hd.setCanAddContent(false);
			throw new FullHDException();
		}
		else {
			hd.setCanAddContent(true);
		}
	}

}

