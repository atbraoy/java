package nano_analytics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class rawData_Plotter {

    private static double xvalue;
	private static double yvalue;
	private XYPlot plot;
    private ChartPanel chartPanel;
    private List<XYSeriesCollection> seriesArrayList = new ArrayList<XYSeriesCollection>();
	private int node;
	private static Color color;
	public rawData_Plotter(String title, String xAxis) {
        super();      
        String yAxis = title;
        XYSeriesCollection dataset = createDataset("Series");
        JFreeChart chart = ChartFactory.createXYLineChart("", xAxis, yAxis,
            dataset, PlotOrientation.VERTICAL, false, false, false);
        chart.setBackgroundPaint(Color.white);
        plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white); 
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        NumberAxis rangeAxis2 = new NumberAxis("Range Axis 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        JPanel content = new JPanel(new BorderLayout());
        chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
    }

    private XYSeriesCollection createDataset(String name) {
        XYSeries series = new XYSeries(name);
        return new XYSeriesCollection(series);
    }

    public ChartPanel getChart() {
        return chartPanel;
    }

    public static  Color random_color(int node){
        int R = (int)(node + Math.random()*200);
        int G = (int)(node + Math.random()*110);
        int B = (int)(node + Math.random()*120);
        color = new Color(R, G, B);
        
        return color;
        
    }
    public void createAdditionalDataset(int node) {
    	node = 0;
        seriesArrayList.add(createDataset("S" + this.node));
        this.plot.setDataset(this.node, seriesArrayList.get(node));

        XYItemRenderer renderer = new StandardXYItemRenderer();
        renderer.setSeriesPaint(0, random_color(node));
        this.plot.setRenderer(this.node, renderer);
    }

    public XYSeriesCollection getXYSeries(int node) {
    	node = 0;
        return seriesArrayList.get(node);
    }

  	public static void main() throws InterruptedException, IOException {

        rawData_Plotter mcf = new rawData_Plotter("Node Current [mA]", "Volt [mV]");
        JFrame frame = new JFrame("Raw Data Visualizer");
        frame.dispose();//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(mcf.getChart());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      
		for (int node = parameters_vault.nstart; node < parameters_vault.nend; node++){
			// creating data set for each node
  	  		mcf.createAdditionalDataset(node);
  	  		
  	  		// calling the start and end experiments (files) from the parameter vault class
			int start = parameters_vault.istart; // start experiment
	        int end = parameters_vault.iend; 	// end experiment
	        
	        // generating the data needed for plotting/visualizing
  			data_vault.generate_data(start, end, node);
  			
  			// looping
	  		for (int index = start; index < end; index++){
	  			// determine the file length (number of readings)
	  			int length = data_vault.file_length(index);
	  			for (int i = 0; i < length ; i++){
	  				yvalue = data_vault.data_x[i][1]; // data is created for the x-axis 
	  		        xvalue = data_vault.data[i][index]; // data is created for the y-axis
	  		        //System.out.println("-- x -- " + xvalue + " -- y -- " + yvalue);
	  		        // storing the (x,y) points in a series per node
	                mcf.getXYSeries(node).getSeries(0).add(xvalue, yvalue);
	                }
	  			}
	  		}
		}
}