package excersises;

import applet.MeasurementGraph;
import com.sun.istack.internal.Nullable;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utilities.Algorithms;
import utilities.InsertionsortThread;
import utilities.Measurement;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by jonathan on 20-11-15.
 */
public class Excercise1_2 {



    public static void main(String[] args) {

        excercise1_2(1);

    }


    private static void excercise1_2(int times){

        XYSeriesCollection dataset = new XYSeriesCollection();
        for(int i = 0; i < times; i++){
            dataset.addSeries(measureEx1_2("meting" + i));

        }

        new MeasurementGraph("opdracht 1.2", "N(numbers)", "T(ms)", dataset).render();
    }


    private static XYSeries measureEx1_2(final String label){
        XYSeries series = new XYSeries(label);


        series.add(measureInsertionSortCon(25000));
        series.add(measureInsertionSortCon(50000));
        series.add(measureInsertionSortCon(100000));
        series.add(measureInsertionSortCon(200000));
        series.add(measureInsertionSortCon(400000));
        series.add(measureInsertionSortCon(800000));
        //series.add(measureInsertionSortCon(1000000));


        System.out.println("measurement for " + label + "is done");
        return series;

    }


    /**Measures the insertion sort on two threads
     *
     * @param amount amount of items, also the x
     * @return
     */
    private static XYDataItem measureInsertionSortCon(int amount){

        final ArrayList<Integer> leftHalf = Utilities.generateRandomNumberArray(amount/2);
        final ArrayList<Integer> rightHalf = Utilities.generateRandomNumberArray(amount/2);



        InsertionsortThread sortLeftThread = new InsertionsortThread(leftHalf);
        InsertionsortThread sortRightThread = new InsertionsortThread(rightHalf);


        Measurement<Integer> measurement = input -> {
            sortLeftThread.start();
            sortRightThread.start();
            // wiat for threads .... 
            try {
                sortLeftThread.join();
                sortRightThread.join();
            } catch( Exception e) {
                System.out.println("Interrupted");
            }

            System.out.println("threads sorted the array, now merging");
            Algorithms.mergeArrayLists(sortLeftThread.getSortedList(), sortRightThread.getSortedList());
        };

        return measurement.measure(amount);

    }











}
