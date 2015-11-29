package excersises;

import applet.MeasurementGraph;
import com.sun.istack.internal.Nullable;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utilities.Algorithms;
import utilities.Measurement;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;

/**
 * Created by jonathan on 18-11-15.
 *
 *
 *
 */
public class Excercise1_1 {


    public static void main(String[] args) {
        plotEx1();
       // test();
    }

    private static void plotEx1(){


        XYSeriesCollection dataset = new XYSeriesCollection();

        // compiler optimalisation
        Measurement<Integer> measurement = input -> {
            Algorithms.insertionSort(Utilities.generateRandomNumberArray(input));

        };
        measurement.measure(10000, 10000);
        measurement.measure(10000, 10000);


        dataset.addSeries(measureEx1_1("meting1"));
        dataset.addSeries(measureEx1_1("meting2"));

        new MeasurementGraph("opdracht 1.1", "N", "T", dataset).render();


    }


    private static XYSeries measureEx1_1(final String label){
        XYSeries series = new XYSeries(label);


        Measurement<Integer> measurement = input -> {
            Algorithms.insertionSort(Utilities.generateRandomNumberArray(input));

        };


        System.out.println("measuring " + label);
        series.add(measurement.measure(25000, 25000));
        series.add(measurement.measure(50000, 50000));
        series.add(measurement.measure(100000, 100000));
        series.add(measurement.measure(200000, 200000));
        series.add(measurement.measure(400000, 400000));
        series.add(measurement.measure(800000, 800000));
        return series;



    }










}
