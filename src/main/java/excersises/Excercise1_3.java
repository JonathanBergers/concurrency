package excersises;

import applet.MeasurementGraph;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utilities.*;

import java.util.ArrayList;

/**
 * Created by falco on 24-11-15.
 */
public class Excercise1_3 {

    public static void main(String[] args) {


        excercise1_3(5);

    }

    private static void excercise1_3(int times){

        // compiler optimalisation
        for(int i = 0; i<5; i++){
            measureEx1_3(" geen meting" + i, 1000);
        }


        int drempelwaarde = 1600;
        XYSeriesCollection dataset0 = new XYSeriesCollection();
        for(int i = 0; i < times; i++){
            dataset0.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset0).render();


    }

    private static XYSeries measureEx1_3(final String label, int maxListSize){
        XYSeries series = new XYSeries(label);



        series.add(measureInsertionSortCon(25000, maxListSize));
        series.add(measureInsertionSortCon(50000, maxListSize));
        series.add(measureInsertionSortCon(100000, maxListSize));
        series.add(measureInsertionSortCon(200000, maxListSize));
        series.add(measureInsertionSortCon(400000, maxListSize));
        series.add(measureInsertionSortCon(800000, maxListSize));
        //series.add(measureInsertionSortCon(1000000));


        System.out.println("measurement for " + label + "is done");
        return series;

    }


    private static XYDataItem measureInsertionSortCon(int amount, int maxListSize){

        ArrayList list = Utilities.generateRandomNumberArray(amount);

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        leftList.addAll(list.subList(0, list.size() / 2));
        rightList.addAll(list.subList((list.size()/2)+1,list.size()));


        Measurement<Integer> measurement = input -> {
            DivideAndSortThread sortLeftList = new DivideAndSortThread(maxListSize, leftList);
            DivideAndSortThread sortrightList = new DivideAndSortThread(maxListSize, rightList);

            try {
                sortLeftList.start();
                sortLeftList.join();
                sortrightList.start();
                sortrightList.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Algorithms.mergeArrayLists(sortLeftList.getList(), sortrightList.getList());
            //System.out.println(Utilities.isListSorted(list));

        };

        return measurement.measure(amount, amount);

    }


}
