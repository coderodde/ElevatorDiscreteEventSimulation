package net.coderodde.simulation.elevator;

/**
 * This class defines a building that may contain a particular number of
 * elevator shafts.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class Building {
    
    private final ElevatorShaft[] elevatorShafts;
    
    public Building(ElevatorShaft... elevatorShafts) {
        this.elevatorShafts = elevatorShafts.clone();
    }
    
    public ElevatorShaft getElevatorShaft(int index) {
        return elevatorShafts[index];
    }
    
    public int getNumberOfElevatorShafts() {
        return elevatorShafts.length;
    }
}
