package gui;

import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
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
	
	private HashMap<String,Slot> slotmap = new HashMap<String,Slot>();
	private HashMap<String,Integer> slotCount = new HashMap<String,Integer>();

	
	public BarChart(HashMap<String,Slot> slotlist) {
		this.slotmap=slotlist;
		slotCount.put("Slot1", 0);
		slotCount.put("Slot2", 0);
		slotCount.put("Slot3", 0);
		slotCount.put("Slot4", 0);
		slotCount.put("Slot5", 0);
	}
	
	public JFreeChart getSlotBarChart() {
		
		
	
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		//?
		dataset.setValue(slotCount.get("Slot1"), "used", "slot#1");
		dataset.setValue(slotCount.get("Slot2"), "used", "slot#2");
		dataset.setValue(slotCount.get("Slot3"), "used", "slot#3");
		dataset.setValue(slotCount.get("Slot4"), "used", "slot#4");
		dataset.setValue(slotCount.get("Slot5"), "used", "slot#5");

			
		
		return ChartFactory.createBarChart("", "", "% used", dataset, PlotOrientation.HORIZONTAL, true, true, false);
	}

	public HashMap<String, Slot> getSlotmap() {
		return slotmap;
	}

	public HashMap<String, Integer> getSlotCount() {
		return slotCount;
	}
	
	
}
