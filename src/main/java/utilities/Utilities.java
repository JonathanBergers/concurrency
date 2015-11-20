package utilities;

import java.util.ArrayList;

/**
 * Created by jonathan on 20-11-15.
 */
public class Utilities {


    /**generates an array with random numbers
     *
     * @param size the amount of numbers for the array
     * @return
     */
    public static ArrayList<Integer> generateRandomNumberArray(final int size){

        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i< size; i++){
            array.add((int)(Math.random() * 100*size * Math.random()));
        }
        return array;

    }


}
