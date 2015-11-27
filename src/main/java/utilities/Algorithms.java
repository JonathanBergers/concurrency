package utilities;

import org.jfree.data.xy.XYDataItem;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by jonathan on 20-11-15.
 */
public class Algorithms {

    /**Measures the time of a call to the given function
     *
     * @param input the input for the function
     * @param algorithmCall function in wich to call a method
     * @param x the x for the graph
     * @param <I> type of input for the function
     * @return
     */
    public static <I> XYDataItem measureAlgorithm(I input, Function<I, Void> algorithmCall, int x){


        long startTime = System.currentTimeMillis();
        algorithmCall.apply(input);
        long endTime = System.currentTimeMillis();
        return new XYDataItem(x, endTime-startTime);
    }

    public static ArrayList<Integer> insertionSort(final ArrayList<Integer> items){


        final ArrayList<Integer> sortedList = new ArrayList<Integer>();
        for(int i : items){
            insertAndSort(sortedList, i);
        }

        return sortedList;

    }


      /**inserts the item into the list and sorts it with insertionsort
     *
     *
     * @param sortedList the list in wich the item needs to be inserted
     * @param intToInsert
     * @return
     */
    private static ArrayList<Integer> insertAndSort(final ArrayList<Integer> sortedList, final int intToInsert){

        if(sortedList.size()==0){
            sortedList.add(intToInsert);
            return sortedList;
        }
        for(int i=0; i<sortedList.size(); i++){

            if(intToInsert <= sortedList.get(i)){
                int temp1 = sortedList.get(i);
                sortedList.set(i, intToInsert);

                for(int j=i+1; j<sortedList.size(); j++){

                    int temp2 = sortedList.get(j);
                    sortedList.set(j, temp1);
                    temp1 = temp2;
                }
                break;
            }
        }
        //System.out.println(Utilities.isListSorted(sortedList));
        return sortedList;
    }

    public static ArrayList<Integer> mergeArrayLists(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        ArrayList<Integer> merged = new ArrayList<>();
        while(!leftList.isEmpty() && !rightList.isEmpty()){
            if(leftList.get(0) < rightList.get(0)){
                merged.add(leftList.remove(0));
                if(leftList.isEmpty()){
                    //merged.addAll(rightList);
                    rightList = leftList;
                }
            } else {
                merged.add(rightList.remove(0));
                if(rightList.isEmpty()){
                    //merged.addAll(leftList);
                    leftList = rightList;
                }
            }
        }

        //System.out.println(Utilities.isListSorted(merged));
        return merged;

    }


}
