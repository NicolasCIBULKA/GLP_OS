package gui;

import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import data.drivers.HardDiskDriver;


/**
 * 
 * bar chart used to display info concerning the storage slots
 * 
 * @author redouane
 *
 */
public class BarChart {

	private HardDiskDriver hd1driver;
	private HardDiskDriver hd2driver;
	
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private HashMap<String,Integer> charCount = new HashMap<String,Integer>();

    ValueAxis yAxis = new NumberAxis("utilisation des slots");
	
	public BarChart(HardDiskDriver hd1driver,HardDiskDriver hd2driver) {

		this.hd1driver=hd1driver;
		this.hd2driver=hd2driver;
		
		charCount.put("Slot1", 0);
		charCount.put("Slot2", 0);
		charCount.put("Slot3", 0);
		charCount.put("Slot4", 0);
		charCount.put("Slot5", 0);
		charCount.put("Slot6", 0);
		charCount.put("Slot7", 0);
		charCount.put("Slot8", 0);
		charCount.put("Slot9", 0);
		charCount.put("Slot10", 0);
		
	}
	
	public JFreeChart getSlotBarChart() {
		
		dataset.setValue(0, "used", "slot#1");
		dataset.setValue(0, "used", "slot#2");
		dataset.setValue(0, "used", "slot#3");
		dataset.setValue(0, "used", "slot#4");
		dataset.setValue(0, "used", "slot#5");
		dataset.setValue(0, "used", "slot#6");
		dataset.setValue(0, "used", "slot#7");
		dataset.setValue(0, "used", "slot#8");
		dataset.setValue(0, "used", "slot#9");
		dataset.setValue(0, "used", "slot#10");
	
		
		return ChartFactory.createBarChart("", "", "% used", dataset, PlotOrientation.HORIZONTAL, true, true, false);
	}

	public void refreshData() {
		
		//to refresh the values of the bar chart:
		//if the slot exist, the number of character used (max size =2000char) in it is put into the hashmap slotcount and divided by 20 to get a % result
		for(int index=1; index<11; index++) {
				if(hd1driver.getHd().getSlotlist().containsKey("slot"+index)) {
				charCount.put("slot"+index, hd1driver.getHd().getSlotlist().get("slot"+index).getCharSize()/20);
			}
				else if (hd2driver.getHd().getSlotlist().containsKey("slot"+index)){
					charCount.put("slot"+index, hd2driver.getHd().getSlotlist().get("slot"+index).getCharSize()/20);
					
				}
		}
		dataset.setValue(charCount.get("slot1"), "used", "slot#1");
		dataset.setValue(charCount.get("slot2"), "used", "slot#2");
		dataset.setValue(charCount.get("slot3"), "used", "slot#3");
		dataset.setValue(charCount.get("slot4"), "used", "slot#4");
		dataset.setValue(charCount.get("slot5"), "used", "slot#5");
		dataset.setValue(charCount.get("slot6"), "used", "slot#6");
		dataset.setValue(charCount.get("slot7"), "used", "slot#7");
		dataset.setValue(charCount.get("slot8"), "used", "slot#8");
		dataset.setValue(charCount.get("slot9"), "used", "slot#9");
		dataset.setValue(charCount.get("slot10"), "used", "slot#10");

}

	public HashMap<String, Integer> getCharCount() {
		return charCount;
	}
	
	

}
