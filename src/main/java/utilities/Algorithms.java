package utilities;

import org.jfree.data.xy.XYDataItem;

import java.util.function.Function;

/**
 * Created by jonathan on 20-11-15.
 */
public class Algorithms {




    public static XYDataItem measureAlgorithm(int n, Function<Integer, Void> algorithmCall){

        long startTime = System.currentTimeMillis();
        algorithmCall.apply(n);
        long endTime = System.currentTimeMillis();
        return new XYDataItem(endTime-startTime, n);
    }

}
