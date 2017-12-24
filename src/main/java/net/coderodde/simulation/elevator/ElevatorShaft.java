package net.coderodde.simulation.elevator;

/**
 * This class defines an elevator shaft.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class ElevatorShaft {
    
    /**
     * The number of the lowest floor.
     */
    private int lowestFloorNumber;
    
    /**
     * The number of the highest floor.
     */
    private int highestFloorNumber;
    
    private ElevatorShaft(int lowestFloorNumber, int highestFloorNumber) {
        if (lowestFloorNumber >= highestFloorNumber) {
            throw new IllegalArgumentException(
                    "Invalid floor numbers: lowest floor = " + 
                    lowestFloorNumber + ", highest floor = " +
                    highestFloorNumber);
        }
    }
    
    public int getLowestFloorNumber() {
        return lowestFloorNumber;
    }
    
    public int getHighestFloorNumber() {
        return highestFloorNumber;
    }
    
    public static LowestFloorNumberSelector createNew() {
        return new LowestFloorNumberSelector();
    }
    
    public static final class LowestFloorNumberSelector {
        
        public HighestFloorNumberSelector 
        withLowestFloorNumber(int lowestFloorNumber) {
            return new HighestFloorNumberSelector(lowestFloorNumber);
        }
    }
    
    public static final class HighestFloorNumberSelector {
        
        private final int lowestFloorNumber;

        public HighestFloorNumberSelector(int lowestFloorNumber) {
            this.lowestFloorNumber = lowestFloorNumber;
        }
        
        public ElevatorShaft withHighestFloorNumber(int highestFloorNumber) {
            return new ElevatorShaft(lowestFloorNumber, highestFloorNumber);
        }
    }
}
