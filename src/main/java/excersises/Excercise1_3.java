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

        //because java
        for(int i = 0; i<5; i++){
            measureEx1_3(" geen meting" + i, 1000);
        }

        //drempelwaarde 100
        int drempelwaarde = 100;
        XYSeriesCollection dataset0 = new XYSeriesCollection();
        for(int i = 0; i < times; i++){
            dataset0.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset0).render();

        // new dataset
        XYSeriesCollection dataset1 = new XYSeriesCollection();

        //drempelwaarde 500
        drempelwaarde = 500;
        for(int i = 0; i < times; i++){
            dataset1.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset1).render();

        // new dataset
        XYSeriesCollection dataset2 = new XYSeriesCollection();

        //drempelwaarde 1000
        drempelwaarde = 1000;
        for(int i = 0; i < times; i++){
            dataset2.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset2).render();

        // new dataset
        XYSeriesCollection dataset3 = new XYSeriesCollection();

        //drempelwaarde 5000
        drempelwaarde = 5000;
        for(int i = 0; i < times; i++){
            dataset3.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset3).render();

        // new dataset
        XYSeriesCollection dataset4 = new XYSeriesCollection();

        //drempelwaarde 10000
        drempelwaarde = 10000;
        for(int i = 0; i < times; i++){
            dataset4.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset4).render();

        // new dataset
        XYSeriesCollection dataset5 = new XYSeriesCollection();

        //drempelwaarde 50000
        drempelwaarde = 50000;
        for(int i = 0; i < times; i++){
            dataset5.addSeries(measureEx1_3("meting" + i, drempelwaarde));

        }
        new MeasurementGraph("opdracht 1.3, Drempelwaarde " + drempelwaarde, "N(numbers)", "T(ms)", dataset5).render();

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
        rightList.addAll(list.subList(list.size()/2+1,list.size()));
        DivideAndSortThread sortLeftList = new DivideAndSortThread(maxListSize, leftList);
        DivideAndSortThread sortrightList = new DivideAndSortThread(maxListSize, rightList);

        Measurement<Integer> measurement = input -> {


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

        return measurement.measure(amount);

    }


}
