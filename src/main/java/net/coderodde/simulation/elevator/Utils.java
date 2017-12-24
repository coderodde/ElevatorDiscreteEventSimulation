package net.coderodde.simulation.elevator;

/**
 * This class contains generic utilities.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class Utils {
    
    public static double checkTime(double time) {
        if (Double.isNaN(time)) {
            throw new IllegalArgumentException("The time is NaN.");
        }
        
        if (time < 0.0) {
            throw new IllegalArgumentException("The time is negative: " + time);
        }
        
        if (Double.isInfinite(time)) {
            throw new IllegalArgumentException("The time is infinite.");
        }
        
        return time;
    }
}
