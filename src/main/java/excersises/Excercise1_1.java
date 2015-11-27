package excersises;

import applet.MeasurementGraph;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utilities.Algorithms;
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
    }

    private static void plotEx1(){


        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("opdracht 1.1");



        Function<ArrayList<Integer>, Void> insertionSort = new Function<ArrayList<Integer>, Void>() {
            public Void apply(ArrayList<Integer> list) {
                Algorithms.insertionSort(list);
                return null;
            }
        };
        long beginTime = System.nanoTime();
        Algorithms.insertionSort(Utilities.generateRandomNumberArray(10000));
        long endTime = System.nanoTime();
        System.out.println((endTime - beginTime)/1000);

//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(25000), insertionSort, 25000));
//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(50000), insertionSort, 50000));
//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(100000), insertionSort, 100000));
//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(200000), insertionSort, 200000));
//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(400000), insertionSort, 400000));
//        series.add(Algorithms.measureAlgorithm(Utilities.generateRandomNumberArray(800000), insertionSort, 800000));
//        dataset.addSeries(series);
//
//        new MeasurementGraph("opdracht 1.1", "N", "T", dataset).render();

    }









}
