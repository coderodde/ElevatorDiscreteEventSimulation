package net.coderodde.simulation.elevator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class defines a building that may contain a particular number of
 * elevator shafts.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class Building implements Iterable<ElevatorShaft> {
    
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
    
    @Override
    public Iterator<ElevatorShaft> iterator() {
        return Collections
                .unmodifiableList(Arrays.asList(elevatorShafts)).iterator();
    }
}
