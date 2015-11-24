package utilities;

import java.util.ArrayList;

/**
 * Created by jonathan on 20-11-15.
 */
public class InsertionsortThread extends Thread{


    private final ArrayList<Integer> unsortedList;
    private ArrayList<Integer> sortedList = new ArrayList<>();


    public InsertionsortThread(ArrayList<Integer> unsortedList) {
        this.unsortedList = unsortedList;
    }

    @Override
    public void run() {
    sortedList = Algorithms.insertionSort(unsortedList);
    }

    public ArrayList<Integer> getSortedList() {
        return sortedList;
    }


}
