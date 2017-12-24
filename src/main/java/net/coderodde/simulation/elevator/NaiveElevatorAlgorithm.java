package net.coderodde.simulation.elevator;

import java.util.List;

/**
 * This class implements a naive elevator algorithm that visits the floors in
 * the order of incoming requests.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class NaiveElevatorAlgorithm extends AbstractElevatorAlgorithm {
    
    private NaiveElevatorAlgorithm(Building building, 
                                   List<ElevatorOrder> elevatorOrders) {
        super(building, elevatorOrders);
    }

    @Override
    public SimulationStatistics simulate() {
        
        return null;
    }
}
