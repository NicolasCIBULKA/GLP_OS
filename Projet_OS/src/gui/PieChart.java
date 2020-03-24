package gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {

	
	public JFreeChart getTypeCountPie() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("CPU used", );
		dataset.setValue("CPU", );

		return ChartFactory.createPieChart("", dataset, true, true, false);
	}
}
