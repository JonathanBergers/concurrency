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

            // divide lists in two
            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();
            leftList.addAll(list.subList(0, list.size() / 2));
            rightList.addAll(list.subList((list.size()/2)+1,list.size()));

            // make threads
            DivideAndSortThread sortLeftList = new DivideAndSortThread(maxListSize, leftList);
            DivideAndSortThread sortrightList = new DivideAndSortThread(maxListSize, rightList);


            try {
                sortLeftList.start();
                sortLeftList.join();
                sortrightList.start();
                sortrightList.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                list = new ArrayList<>();
                return;
            }

            list = Algorithms.mergeArrayLists(sortLeftList.getList(), sortrightList.getList());
            //System.out.println(Utilities.isListSorted(list));

        } else {
            list = Algorithms.insertionSort(list);
            //System.out.println(Utilities.isListSorted(list));
        }
    }
    public ArrayList<Integer> getList(){
        //System.out.println(Utilities.isListSorted(list));
        return list;
    }


}
