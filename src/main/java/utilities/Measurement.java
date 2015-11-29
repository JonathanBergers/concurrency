package utilities;

import com.sun.istack.internal.Nullable;
import org.jfree.data.xy.XYDataItem;

/**
 * Created by jonathan on 22-11-15.
 * Interface om metingen mee te doen
 */
public interface Measurement<T> {


    /**Starts the timer and doest the work, then stops the timer and returns the meaurement
     *
     * @param xPosition
     * @param input
     * @return
     */
    default  XYDataItem measure(final int xPosition, @Nullable T input){

        long startTime = System.currentTimeMillis();
        doSomeWork(input);
        long endTime = System.currentTimeMillis();
        System.out.println("Measurement done, X: " + xPosition + " , Y: " + (endTime-startTime));
        return new XYDataItem(xPosition, endTime-startTime);



    }

    /**Describe the actions that need to be measured in this method.
     *
     *
     * @param input
     */
    void doSomeWork(@Nullable T input);


}
