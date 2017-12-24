package net.coderodde.simulation.elevator;

import java.util.Objects;

/**
 * This class models an elevator order.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class ElevatorOrder {
    
    /**
     * The elevator client.
     */
    private final ElevatorClient elevatorClient;
    
    /**
     * The target elevator shaft.
     */
    private final ElevatorShaft elevatorShaft;
    
    /**
     * The source floor.
     */
    private final int sourceFloor;
    
    /**
     * The target floor.
     */
    private final int targetFloor;
    
    private ElevatorOrder(ElevatorClient elevatorClient,
                          ElevatorShaft elevatorShaft,
                          int sourceFloor,
                          int targetFloor) {
        this.elevatorClient = elevatorClient;
        this.elevatorShaft = elevatorShaft;
        this.sourceFloor = sourceFloor;
        this.targetFloor = targetFloor;
    }
    
    public static ElevatorClientSelector createNew() {
        return new ElevatorClientSelector();
    }
    
    public static final class ElevatorClientSelector {
        
        public ElevatorShaftSelector 
        withElevatorShaft(ElevatorClient elevatorClient) {
            return new ElevatorShaftSelector(elevatorClient);
        }
    }
    
    public static final class ElevatorShaftSelector {

        private final ElevatorClient elevatorClient;
        
        public ElevatorShaftSelector(ElevatorClient elevatorClient) {
            this.elevatorClient = 
                    Objects.requireNonNull(
                            elevatorClient, 
                            "The input ElevatorClient is null.");
        }
        
        public SourceFloorSelector 
        withElevatorShaft(ElevatorShaft elevatorShaft) {
            return new SourceFloorSelector(elevatorClient, elevatorShaft);
        }
    }
    
    public static final class SourceFloorSelector {
        
        private final ElevatorClient elevatorClient;
        private final ElevatorShaft elevatorShaft;
        
        private SourceFloorSelector(ElevatorClient elevatorClient,
                                    ElevatorShaft elevatorShaft) {
            this.elevatorClient = elevatorClient;
            this.elevatorShaft = 
                    Objects.requireNonNull(
                            elevatorShaft,
                            "The input ElevatorShaft is null.");
        }
        
        public TargetFloorSelector withSourceFloor(int sourceFloor) {
            return new TargetFloorSelector(elevatorClient, 
                                           elevatorShaft, 
                                           sourceFloor);
        }
    }
    
    public static final class TargetFloorSelector {
        
        private final ElevatorClient elevatorClient;
        private final ElevatorShaft elevatorShaft;
        private final int sourceFloor;
        
        private TargetFloorSelector(ElevatorClient elevatorClient,
                                    ElevatorShaft elevatorShaft,
                                    int sourceFloor) {
            this.elevatorClient = elevatorClient;
            this.elevatorShaft = elevatorShaft;
            this.sourceFloor = sourceFloor;
        }
        
        public ElevatorOrder withTargetFloor(int targetFloor) {
            return new ElevatorOrder(elevatorClient,
                                     elevatorShaft,
                                     sourceFloor,
                                     targetFloor);
        }
    }
}