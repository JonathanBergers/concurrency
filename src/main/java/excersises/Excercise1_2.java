//package excersises;
//
//import applet.MeasurementGraph;
//import org.jfree.data.xy.XYDataItem;
//import org.jfree.data.xy.XYSeries;
//import org.jfree.data.xy.XYSeriesCollection;
//import utilities.Measurement;
//import utilities.Utilities;
//
//import java.util.ArrayList;
//
///**
// * Created by jonathan on 20-11-15.
// */
//public class Excercise1_2 {
//
//    private static Insertionsort insertionsort = new Insertionsort();
//    private static ArrayList<Integer> temp = null;
//
//
//    protected volatile XYSeriesCollection dataset = new XYSeriesCollection();
//
//
//    public static void main(String[] args) {
//
//        excercise1_2(3);
//
//    }
//
//
//    public static void excercise1_2(int times){
//
//        XYSeriesCollection dataset = new XYSeriesCollection();
//        for(int i = 0; i < times; i++){
//            dataset.addSeries(measureEx1_2("meting" + i));
//
//        }
//
//        new MeasurementGraph("opdracht 1.2", "N(numbers)", "T(ms)", dataset).render();
//    }
//
//
//    private static XYSeries measureEx1_2(final String label){
//        XYSeries series = new XYSeries(label);
//
//
//        series.add(measureInsertionSortCon(25000));
//        series.add(measureInsertionSortCon(50000));
//        series.add(measureInsertionSortCon(100000));
//        series.add(measureInsertionSortCon(200000));
//        series.add(measureInsertionSortCon(400000));
//        series.add(measureInsertionSortCon(800000));
//        series.add(measureInsertionSortCon(1000000));
//
//
//        return series;
//
//    }
//
//
//    /**Measures the insertion sort on two threads
//     *
//     * @param amount amount of items, also the x
//     * @return
//     */
//    private static XYDataItem measureInsertionSortCon(int amount){
//
//        final ArrayList<Integer> leftHalf = Utilities.generateRandomNumberArray(amount/2);
//        final ArrayList<Integer> rightHalf = Utilities.generateRandomNumberArray(amount/2);
//
//
//
//        InsertionsortThread sortLeftThread = new InsertionsortThread(leftHalf);
//        InsertionsortThread sortRightThread = new InsertionsortThread(rightHalf);
//
//
//
//        Measurement<Integer> measurement = input -> {
//            sortLeftThread.start();
//            sortRightThread.start();
//
//            i = 100;
//            sortRightThread.join();
//
//            mergeArrayLists(sortLeftThread.getSortedList(), sortRightThread.getSortedList());
//        };
//
//        return measurement.measure(amount);
//
//    }
//
//
//
//    private static ArrayList<Integer> mergeArrayLists(ArrayList<Integer> numbers1, ArrayList<Integer> numbers2){
//        ArrayList<Integer> merged = new ArrayList<Integer>();
//        while(!numbers1.isEmpty() && !numbers2.isEmpty()){
//            if(numbers1.get(0) < numbers2.get(0)){
//                merged.add(numbers1.remove(0));
//                if(numbers1.isEmpty()){
//                    merged.addAll(numbers2);
//                    numbers2 = numbers1;
//                }
//            } else {
//                merged.add(numbers2.remove(0));
//                if(numbers2.isEmpty()){
//                    merged.addAll(numbers1);
//                    numbers1 = numbers2;
//                }
//            }
//        }
//
//        //check if the list is sorted
//        System.out.println(insertionsort.isListSorted(merged));
//        return merged;
//
//    }
//
//
//
//
//
//
//
//}
