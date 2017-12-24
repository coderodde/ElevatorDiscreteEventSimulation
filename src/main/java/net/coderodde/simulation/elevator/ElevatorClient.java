package net.coderodde.simulation.elevator;

import static net.coderodde.simulation.elevator.Utils.checkTime;

/**
 * This class models the elevator client.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public class ElevatorClient {
   
    /**
     * The maximum number of seconds the client is ready to wait for the 
     * elevator to arrive.
     */
    private final double maximumPatienceTime;
    
    private ElevatorClient(double maximumPatienceTime) {
        this.maximumPatienceTime = checkTime(maximumPatienceTime);
    }
}
