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
     * The source floor.
     */
    private final int sourceFloor;
    
    /**
     * The target floor.
     */
    private final int targetFloor;
    
    /**
     * The moment at which the elevator client arrives to the queue of persons
     * waiting for the elevator to arrive.
     */
    private final double orderTime;
    
    private ElevatorOrder(ElevatorClient elevatorClient,
                          int sourceFloor,
                          int targetFloor,
                          double orderTime) {
        this.elevatorClient = elevatorClient;
        this.sourceFloor = sourceFloor;
        this.targetFloor = targetFloor;
        this.orderTime = orderTime;
    }
    
    public ElevatorClient getElevatorClient() {
        return elevatorClient;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public double getOrderTime() {
        return orderTime;
    }
    
    public static ElevatorClientSelector createNew() {
        return new ElevatorClientSelector();
    }
    
    public static final class ElevatorClientSelector {
        
        public SourceFloorSelector 
        withElevatorClient(ElevatorClient elevatorClient) {
            return new SourceFloorSelector(elevatorClient);
        }
    }
    
    public static final class SourceFloorSelector {
        
        private final ElevatorClient elevatorClient;
        
        private SourceFloorSelector(ElevatorClient elevatorClient) {
            this.elevatorClient = 
                    Objects.requireNonNull(elevatorClient, 
                                           "The ElevatorClient is null.");
        }
        
        public TargetFloorSelector withSourceFloor(int sourceFloor) {
            return new TargetFloorSelector(elevatorClient,
                                           sourceFloor);
        }
    }
    
    public static final class TargetFloorSelector {
        
        private final ElevatorClient elevatorClient;
        private final int sourceFloor;
        
        private TargetFloorSelector(ElevatorClient elevatorClient,
                                    int sourceFloor) {
            this.elevatorClient = elevatorClient;
            this.sourceFloor = sourceFloor;
        }
        
        public OrderTimeSelector withTargetFloor(int targetFloor) {
            return new OrderTimeSelector(elevatorClient,
                                         sourceFloor,
                                         targetFloor);
        }
    }
    
    public static final class OrderTimeSelector {
        
        private final ElevatorClient elevatorClient;
        private final int sourceFloor;
        private final int targetFloor;
        
        private OrderTimeSelector(ElevatorClient elevatorClient,
                                  int sourceFloor,
                                  int targetFloor) {
            this.elevatorClient = elevatorClient;
            this.sourceFloor = sourceFloor;
            this.targetFloor = targetFloor;
        }
        
        public ElevatorOrder withOrderTime(double orderTime) {
            return new ElevatorOrder(elevatorClient,
                                     sourceFloor,
                                     targetFloor,
                                     checkOrderTime(orderTime));
        }
        
        private double checkOrderTime(double orderTime) {
            if (Double.isNaN(orderTime) || Double.isInfinite(orderTime)) {
                throw new IllegalArgumentException(
                        "Bad order time: " + orderTime);
            }
            
            return orderTime;
        }
    }
}
