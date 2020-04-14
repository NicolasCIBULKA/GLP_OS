package gui;

import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import data.drivers.HardDiskDriver;
import data.peripheral.Slot;

/**
 * 
 * bar chart used to display info concerning the storage slots
 * 
 * @author redouane
 *
 */
public class BarChart {
	
	private HardDiskDriver hddriver;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private HashMap<String,Integer> charCount = new HashMap<String,Integer>();

	
	public BarChart(HardDiskDriver harddisk) {

		this.hddriver=harddisk;
		
		charCount.put("Slot1", 0);
		charCount.put("Slot2", 0);
		charCount.put("Slot3", 0);
		charCount.put("Slot4", 0);
		charCount.put("Slot5", 0);
	}
	
	public JFreeChart getSlotBarChart() {
			
		dataset.setValue(0, "used", "slot#1");
		dataset.setValue(0, "used", "slot#2");
		dataset.setValue(15, "used", "slot#3");
		dataset.setValue(0, "used", "slot#4");
		dataset.setValue(0, "used", "slot#5");
			
		
		return ChartFactory.createBarChart("", "", "% used", dataset, PlotOrientation.HORIZONTAL, true, true, false);
	}

	public void refreshData() {
		//to refresh the values of the bar chart:
		//if the slot exist, the number of character used (max size =2000char) in it is put into the hasmap slotcount and divided by 20 to get a % result
		for(int index=1; index<6; index++) {
				if(hddriver.getHd().getSlotlist().containsKey("slot"+index)) {
				charCount.put("slot"+index, hddriver.getHd().getSlotlist().get("slot"+index).getCharSize()/20);
			}
		}
		dataset.setValue(charCount.get("slot1"), "used", "slot#1");
		dataset.setValue(charCount.get("slot2"), "used", "slot#2");
		dataset.setValue(charCount.get("slot3"), "used", "slot#3");
		dataset.setValue(charCount.get("slot4"), "used", "slot#4");
		dataset.setValue(charCount.get("slot5"), "used", "slot#5");
	}
	

	public HashMap<String, Integer> getCharCount() {
		return charCount;
	}
	
	
}
