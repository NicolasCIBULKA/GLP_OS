package gui;

import java.util.HashMap;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import process.rrobin.Rrobin;


/**
 * this class is used to print the two pie charts in the GUI
 * 
 * @author redouane
 *
 */

public class PieChart {
	Rrobin roundrobin;
	
	

	 public PieChart(Rrobin rr) {
		 this.roundrobin=rr;
	 }
	 
	 
	public JFreeChart getCpuPie() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		dataset.setValue("CPU used", roundrobin.getCPUUsing() );
		dataset.setValue("CPU left", 100-roundrobin.getCPUUsing() );

		return ChartFactory.createPieChart("CPU and Slots", dataset, true, true, false);
	}
	
	
	
}
