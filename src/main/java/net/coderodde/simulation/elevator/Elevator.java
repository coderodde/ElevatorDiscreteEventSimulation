package net.coderodde.simulation.elevator;

import static net.coderodde.simulation.elevator.Utils.checkTime;

/**
 * This class encapsulates all the parameters describing an elevator.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class Elevator {
    
    /**
     * Gives the number of seconds it takes an elevator to advance one floor up
     * or down.
     */
    private final double secondsPerFloor;
    
    /**
     * The time in seconds before the doors open after the elevator has stopped.
     * Also, this is the time the elevator waits between having closed the doors
     * and starting moving.
     */
    private final double waitingTime;
    
    /**
     * The time in seconds it takes to close/open the doors.
     */
    private final double doorOpeningClosingTime;
    
    /**
     * The number of seconds the elevator keeps its doors open for the clients
     * to enter/exit.
     */
    private final double entranceDuration;
    
    private Elevator(double secondsPerFloor,
                     double waitingTime,
                     double doorOpeningClosingTime,
                     double entranceDuration) {
        this.secondsPerFloor = secondsPerFloor;
        this.waitingTime = waitingTime;
        this.doorOpeningClosingTime = doorOpeningClosingTime;
        this.entranceDuration = entranceDuration;
    }
    
    public double getSecondsPerFloor() {
        return secondsPerFloor;
    }
    
    public double getWaitingTime() {
        return waitingTime;
    }
    
    public double getDoorOpeningClosingTime() {
        return doorOpeningClosingTime;
    }
    
    public double getEntranceDuration() {
        return entranceDuration;
    }
    
    public SecondsPerFloorSelector createNew() {
        return new SecondsPerFloorSelector();
    }
    
    public static final class SecondsPerFloorSelector {
        
        public WaitingTimeSelector withSecondsPerFloor(double secondsPerFloor) {
            checkTime(secondsPerFloor);
            return new WaitingTimeSelector(secondsPerFloor);
        }
    }
    
    public static final class WaitingTimeSelector {
        
        private final double secondsPerFloor;
        
        WaitingTimeSelector(double secondsPerFloor) {
            this.secondsPerFloor = secondsPerFloor;
        }
        
        public DoorOpeningClosingTimeSelector 
        withWaitingTime(double waitingTime) {
            checkTime(waitingTime);
            return new DoorOpeningClosingTimeSelector(secondsPerFloor,
                                                      waitingTime);
        }
    }
    
    public static final class DoorOpeningClosingTimeSelector {
        
        private final double secondsPerFloor;
        private final double waitingTime;
        
        DoorOpeningClosingTimeSelector(double secondsPerFloor,
                                       double waitingTime) {
            this.secondsPerFloor = secondsPerFloor;
            this.waitingTime = waitingTime;
        }
        
        public EntranceDurationSelector 
        withDoorOpeningClosingTimeSelctor(double doorOpeningClosingTime) {  
            checkTime(doorOpeningClosingTime);
            return new EntranceDurationSelector(secondsPerFloor,
                                                waitingTime,
                                                doorOpeningClosingTime);
        }
    }
    
    public static final class EntranceDurationSelector {
        
        private final double secondsPerFloor;
        private final double waitingTime;
        private final double doorOpeningClosingTime;
        
        EntranceDurationSelector(double secondsPerFloor,
                                 double waitingTime,
                                 double doorOpeningClosingTime) {
            this.secondsPerFloor = secondsPerFloor;
            this.waitingTime = waitingTime;
            this.doorOpeningClosingTime = doorOpeningClosingTime;
        }
        
        public Elevator withEntranceDuration(double entranceDuration) {
            checkTime(entranceDuration);
            return new Elevator(secondsPerFloor,
                                waitingTime,
                                doorOpeningClosingTime,
                                entranceDuration);
        }
    }
}
