package gui;

import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import data.peripheral.Slot;

/**
 * 
 * bar chart used to display info concerning the storage slots
 * 
 * @author redouane
 *
 */
public class BarChart {
	
	
	private HashMap<String,Slot> slotCount = new HashMap<String,Slot>();

	
	public BarChart(HashMap<String,Slot> hmap) {
		this.slotCount=hmap;
	}
	
	public JFreeChart getSlotBarChart() {
		
		
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//?
		dataset.setValue(2000-slotCount.get("Slot1").getCharSize(), "series", "slot#1");
		dataset.setValue(2000-slotCount.get("Slot2").getCharSize(), "series", "slot#2");
		dataset.setValue(2000-slotCount.get("Slot3").getCharSize(), "series", "slot#3");
		dataset.setValue(2000-slotCount.get("Slot4").getCharSize(), "series", "slot#4");
		dataset.setValue(2000-slotCount.get("Slot5").getCharSize(), "series", "slot#5");

			
		
		
		return ChartFactory.createBarChart("Storage", "slot #", "% used", dataset);
	}
}
