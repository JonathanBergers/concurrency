package utilities;

import java.util.ArrayList;

/**
 * Created by falco on 24-11-15.
 */
public class DivideAndSortThread extends Thread {

    final int maxListSize;
    ArrayList<Integer> list;

    public DivideAndSortThread(final int maxListSize, ArrayList<Integer> list){
        this.maxListSize = maxListSize;
        this.list = list;
    }

    @Override
    public void run() {
        if(list.size()>maxListSize){
            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();
            leftList.addAll(list.subList(0, list.size() / 2));
            rightList.addAll(list.subList(list.size()/2+1,list.size()));

            DivideAndSortThread

        } else {
            list = Algorithms.insertionSort(list);
        }
    }
    public ArrayList<Integer> getList(){
        return list;
    }


}
