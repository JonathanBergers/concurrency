package excersises;

import applet.MeasurementGraph;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by jonathan on 18-11-15.
 *
 *
 *
 */
public class Excercise1 {


    public static void main(String[] args) {
        plotEx1();
    }

    private static void plotEx1(){


        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries series = new XYSeries("opdracht 1.1");



        Function<Integer, Void> algorithm1 = new Function<Integer, Void>() {
            public Void apply(Integer integer) {

                //TODO voer insertionsort uit.

                return null;

            }
        };

        series.add(measureAlgorithm(25000,algorithm1));
        series.add(measureAlgorithm(50000,algorithm1));
        series.add(measureAlgorithm(100000,algorithm1));
        series.add(measureAlgorithm(200000,algorithm1));
        series.add(measureAlgorithm(400000,algorithm1));
        series.add(measureAlgorithm(800000,algorithm1));
        dataset.addSeries(series);

        new MeasurementGraph("opdracht 1", "T", "N", dataset).render();

    }

    private static XYDataItem measureAlgorithm(int n, Function<Integer, Void> algorithmCall){

        long startTime = System.currentTimeMillis();
        algorithmCall.apply(n);
        long endTime = System.currentTimeMillis();
        return new XYDataItem(endTime-startTime, n);
    }


    /**generates an array with random numbers
     *
     * @param size the amount of numbers for the array
     * @return
     */
    private static ArrayList<Integer> generateRandomNumberArray(final int size){

        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i< size; i++){
            array.add((int)(Math.random() * 100*size * Math.random()));
        }
        return array;

    }

    static class Algorithms {


        static void insertionSort(final ArrayList<Integer> list){


        }


    }



}
