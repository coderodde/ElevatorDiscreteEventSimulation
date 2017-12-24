package net.coderodde.simulation.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import static net.coderodde.simulation.elevator.Utils.choose;

/**
 * This class encapsulates a population in a building.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class ElevatorOrderGenerator {
    
    private final Building building;
    private final Random random = new Random();
    private final List<ElevatorClient> elevatorClients = new ArrayList<>();
    
    public ElevatorOrderGenerator(Building building) {
        this.building =
                Objects.requireNonNull(building, 
                                       "The input Building is null.");
    }
    
    public void addElevatorClient(ElevatorClient elevatorClient) {
        this.elevatorClients.add(
                Objects.requireNonNull(
                        elevatorClient, 
                        "The input ElevatorClient is null."));
    }
    
    public List<ElevatorOrder> generateElevatorOrders(int numberOfOrders,
                                                      double startTime,
                                                      double endTime) {
        checkTimes(startTime, endTime);
        List<ElevatorOrder> orders = new ArrayList<>(numberOfOrders);
        double timeRange = endTime - startTime;
        int elevatorShafts = building.getNumberOfElevatorShafts();
        
        for (int i = 0; i < numberOfOrders; ++i) {
            ElevatorClient elevatorClient = choose(elevatorClients, random);
            int elevatorShaftNumber = random.nextInt(elevatorShafts);
            
            ElevatorShaft elevatorShaft =
                    building.getElevatorShaft(elevatorShaftNumber);
            
            int sourceFloorNumber = elevatorShaft.getRandomFloorNumber(random);
            int targetFloorNumber = elevatorShaft.getRandomFloorNumber(random);
            
            while (targetFloorNumber == sourceFloorNumber) {
                targetFloorNumber = elevatorShaft.getRandomFloorNumber(random);
            }
            
            double orderTime = startTime + timeRange * random.nextDouble();
            
            ElevatorOrder elevatorOrder =
                    ElevatorOrder
                            .createNew()
                            .withElevatorClient(elevatorClient)
                            .withElevatorShaft(elevatorShaft)
                            .withSourceFloor(sourceFloorNumber)
                            .withTargetFloor(targetFloorNumber)
                            .withOrderTime(orderTime);
            
            orders.add(elevatorOrder);
        }
        
        return orders;
    }
    
    private void checkTimes(double startTime, double endTime) {
        if (startTime >= endTime) {
            throw new IllegalArgumentException(
                    "startTime(" + startTime + ") >= endTime(" + endTime + ")");
        }
    }
}
