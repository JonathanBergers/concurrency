package excersises;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import utilities.Utilities;

import java.util.ArrayList;

/**
 * Created by jonathan on 20-11-15.
 */
public class Excercise1_2 {

    private static Insertionsort insertionsort = new Insertionsort();
    private static ArrayList<Integer> temp = null;


    protected volatile XYSeriesCollection dataset = new XYSeriesCollection();


    public static void main(String[] args) {

        excercise1_2();

    }


    private static void excercise1_2(){


        //the size of the arrayList can be changed here
        int size = 10000;




        InsertionSortConc insertionSortConc1 = new InsertionSortConc(Utilities.generateRandomNumberArray(size/2));
        InsertionSortConc insertionSortConc2 = new InsertionSortConc(Utilities.generateRandomNumberArray(size/2));
        insertionSortConc1.start(); insertionSortConc2.start();




    }

    /**
     *
     * @param numbers the sorted arrayList from the thread that is finished.
     */
    protected static void afterThread(ArrayList<Integer> numbers){
        if(temp == null){
            temp = numbers;
        } else {
            mergeArrayLists(temp, numbers);
        }
    }
    private static ArrayList<Integer> mergeArrayLists(ArrayList<Integer> numbers1, ArrayList<Integer> numbers2){
        ArrayList<Integer> merged = new ArrayList<Integer>();
        while(!numbers1.isEmpty() && !numbers2.isEmpty()){
            if(numbers1.get(0) < numbers2.get(0)){
                merged.add(numbers1.remove(0));
                if(numbers1.isEmpty()){
                    merged.addAll(numbers2);
                    numbers2 = numbers1;
                }
            } else {
                merged.add(numbers2.remove(0));
                if(numbers2.isEmpty()){
                    merged.addAll(numbers1);
                    numbers1 = numbers2;
                }
            }
        }

        //check if the list is sorted
        System.out.println(insertionsort.isListSorted(merged));
        return merged;

    }


    static class InsertionSortConc extends Thread {


        private final ArrayList<Integer> numbers;
        private final Insertionsort insertionsort;

        public InsertionSortConc(ArrayList<Integer> numbers) {
            this.numbers = numbers;
            insertionsort = new Insertionsort();
        }

        @Override
        public void run() {
             afterThread(insertionsort.sortList(numbers));

        }





    }




}
