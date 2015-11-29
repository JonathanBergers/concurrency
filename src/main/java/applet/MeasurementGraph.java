package applet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.*;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

/**
 * Created by jonathan on 18-11-15.
 *
 * Met deze klasse kun je een grafiek plotten.
 */
public class MeasurementGraph extends JFrame{

    XYSeriesCollection dataset;
    private final String title, xLabel, yLabel;

    public void render(){




        // based on the dataset we create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(title, xLabel, yLabel, dataset);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application

        setContentPane(chartPanel);

        //show
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }



    public MeasurementGraph(String title, String xLabel, String yLabel, XYSeriesCollection dataset) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.dataset = dataset;




    }
    public MeasurementGraph(String title, String xLabel, String yLabel) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
        this.dataset = new XYSeriesCollection();

    }




}
