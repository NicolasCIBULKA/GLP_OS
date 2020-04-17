package gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		charCount.put("hd1_slot1", 0);
		charCount.put("hd1_slot2", 0);
		charCount.put("hd1_slot3", 0);
		charCount.put("hd1_slot4", 0);
		charCount.put("hd1_slot5", 0);
		charCount.put("hd2_slot1", 0);
		charCount.put("hd2_slot2", 0);
		charCount.put("hd2_slot3", 0);
		charCount.put("hd2_slot4", 0);
		charCount.put("hd2_slot5", 0);
		
	}
	
	public JFreeChart getSlotBarChart() {
		
		dataset.setValue(0, "used", "hd1_slot1");
		dataset.setValue(0, "used", "hd1_slot2");
		dataset.setValue(0, "used", "hd1_slot3");
		dataset.setValue(0, "used", "hd1_slot4");
		dataset.setValue(0, "used", "hd1_slot5");
		dataset.setValue(0, "used", "hd2_slot1");
		dataset.setValue(0, "used", "hd2_slot2");
		dataset.setValue(0, "used", "hd2_slot3");
		dataset.setValue(0, "used", "hd2_slot4");
		dataset.setValue(0, "used", "hd2_slot5");
	
		
		return ChartFactory.createBarChart("", "", "% used", dataset, PlotOrientation.HORIZONTAL, true, true, false);
	}

	public void refreshData() {
		
		//to refresh the values of the bar chart:
		/*
		try {
			BufferedReader brread = new BufferedReader(new FileReader(hd1driver.getHd().getHdPosition()+"info.csv"));
			String line;
			String[] tabline;
			while((line = brread.readLine()) != null) {
				tabline = line.split(";");
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//if the slot exist, the number of character used (max size =2000char) in it is put into the hashmap slotcount and divided by 20 to get a % result
		for(int index=1; index<= 5; index++) {
			if(hd1driver.getSlotinfo().containsKey("slot"+index)) {
				String stroctets = hd1driver.getSlotinfo().get("slot"+index);
				int octet = Integer.parseInt(stroctets);
			charCount.put("hd1_slot"+index, octet/20);
			}
		}
		for(int index=1; index<= 5; index++) {
			if (hd2driver.getSlotinfo().containsKey("slot"+index)){
				String stroctets = hd2driver.getSlotinfo().get("slot"+index);
				int octet = Integer.parseInt(stroctets);
				//System.out.println("hd"+hd1driver.getHd().getHdNumber()+"_slot"+index);
				charCount.put("hd2_slot"+index, octet/20);
			}
		}
		
		dataset.setValue(charCount.get("hd1_slot1"), "used", "hd1_slot1");
		dataset.setValue(charCount.get("hd1_slot2"), "used", "hd1_slot2");
		dataset.setValue(charCount.get("hd1_slot3"), "used", "hd1_slot3");
		dataset.setValue(charCount.get("hd1_slot4"), "used", "hd1_slot4");
		dataset.setValue(charCount.get("hd1_slot5"), "used", "hd1_slot5");
		dataset.setValue(charCount.get("hd2_slot1"), "used", "hd2_slot1");
		dataset.setValue(charCount.get("hd2_slot2"), "used", "hd2_slot2");
		dataset.setValue(charCount.get("hd2_slot3"), "used", "hd2_slot3");
		dataset.setValue(charCount.get("hd2_slot4"), "used", "hd2_slot4");
		dataset.setValue(charCount.get("hd2_slot5"), "used", "hd2_slot5");

}

	public HashMap<String, Integer> getCharCount() {
		return charCount;
	}
	
	

}
