package net.coderodde.simulation.elevator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This abstract class defines the API for elevator operating algorithms.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public abstract class AbstractElevatorAlgorithm {
    
    protected final Building building;
    protected final List<ElevatorOrder> elevatorOrders = new ArrayList<>();
    protected final Map<Integer, 
                        List<ElevatorShaft>> floorNumberToShafts = 
                        new HashMap<>();
    
    protected final Map<Integer, 
                        Deque<ElevatorClient>> floorNumberToClientQueue = 
                        new HashMap<>();
    
    protected AbstractElevatorAlgorithm(Building building,
                                        List<ElevatorOrder> elevatorOrders) {
        this.building = building;
        this.elevatorOrders.addAll(elevatorOrders);
        
        // Map each existing floor to the list of elevator shafts that service
        // that very floor:
        for (ElevatorShaft elevatorShaft : building) {
            for (int i = elevatorShaft.getLowestFloorNumber();
                    i <= elevatorShaft.getHighestFloorNumber();
                    i++) {
                List<ElevatorShaft> elevatorShaftList = 
                        floorNumberToShafts.get(i);
                
                if (elevatorShaftList == null) {
                    floorNumberToShafts
                            .put(i, elevatorShaftList = new ArrayList<>());
                }
                
                elevatorShaftList.add(elevatorShaft);
            }
        }
        
        // Create the client queues, one queue per floor:
        for (Integer floorNumber : floorNumberToShafts.keySet()) {
            floorNumberToClientQueue.put(floorNumber, new ArrayDeque<>());
        }
    }
    
    /**
     * Runs the actual simulation.
     * 
     * @return the result statistics.
     */
    public abstract SimulationStatistics simulate();
}
