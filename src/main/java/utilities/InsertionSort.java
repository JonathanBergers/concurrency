package utilities;

import java.util.ArrayList;

/**
 * Created by jonathan on 22-11-15.
 */
public class InsertionSort extends Thread{


    public static void main(String[] args) {

        System.out.println(Algorithms.insertionSort(Utilities.generateRandomNumberArray(10)));


        //new InsertionSort(Utilities.generateRandomNumberArray(5)).start();




    }


    private final InsertionSort parent;
    protected volatile ArrayList<Integer> items = new ArrayList<Integer>();

    public InsertionSort(InsertionSort parent, ArrayList<Integer> items) {
        this.parent = parent;
        this.items = items;
    }
    public InsertionSort() {
        parent = null;

    }
    public InsertionSort(ArrayList<Integer> items) {
        this.parent = null;
        this.items = items;
        System.out.println(items.toString());
    }


    synchronized void addItems(ArrayList<Integer> sortedItems){

        System.out.println("adding list to merge");
        final ArrayList<Integer> merged = new ArrayList<Integer>();
        while(!items.isEmpty() && !sortedItems.isEmpty()){
            if(items.get(0) < sortedItems.get(0)){
                merged.add(items.remove(0));
                if(items.isEmpty()){
                    merged.addAll(sortedItems);
                    sortedItems = items;
                }
            } else {
                merged.add(sortedItems.remove(0));
                if(sortedItems.isEmpty()){
                    merged.addAll(items);
                    items = sortedItems;
                }
            }
        }
        
        items.clear();
        items.addAll(merged);

        System.out.println(items.toString());
        System.out.println("list merged, sorted?" + Utilities.isListSorted(items));
        
    }


    @Override
    public void run() {
        ArrayList<Integer> sortedItems = Algorithms.insertionSort(items);

        System.out.println(sortedItems.toString());
        if(parent == null){


            addItems(Algorithms.insertionSort(items));
            return;
        }
        parent.addItems(Algorithms.insertionSort(items));

    }
}
