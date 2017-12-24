package net.coderodde.simulation.elevator;

/**
 * This class holds all the information describing the simulation statistics.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Dec 24, 2017)
 */
public final class SimulationStatistics {
    
    private final int ordersTotal;
    private final int ordersServed;
    private final double averageWaitTime;
    private final double averageTravelTime;
    private final double averageTravelDistance;
    private final double waitTimeStandardDeviation;
    private final double travelTimeStandardDeviation;
    private final double travelDistanceStandardDeviation;

    private SimulationStatistics(int ordersTotal,
                                 int ordersServed,
                                 double averageWaitTime,
                                 double averageTravelTime,
                                 double averageTravelDistance,
                                 double waitTimeStandardDeviation,
                                 double travelTimeStandardDeviation,
                                 double travelDistancesStandardDeviation) {
        this.ordersTotal = ordersTotal;
        this.ordersServed = ordersServed;
        this.averageWaitTime = averageWaitTime;
        this.averageTravelTime = averageTravelTime;
        this.averageTravelDistance = averageTravelDistance;
        this.waitTimeStandardDeviation = waitTimeStandardDeviation;
        this.travelTimeStandardDeviation = travelTimeStandardDeviation;
        this.travelDistanceStandardDeviation = travelDistancesStandardDeviation;
    }
    
    public int getOrdersTotal() {
        return ordersTotal;
    }

    public int getOrdersServed() {
        return ordersServed;
    }

    public double getAverageWaitTime() {
        return averageWaitTime;
    }

    public double getAverageTravelTime() {
        return averageTravelTime;
    }

    public double getAverageTravelDistance() {
        return averageTravelDistance;
    }

    public double getWaitTimeStandardDeviation() {
        return waitTimeStandardDeviation;
    }

    public double getTravelTimeStandardDeviation() {
        return travelTimeStandardDeviation;
    }

    public double getTravelDistanceStandardDeviation() {
        return travelDistanceStandardDeviation;
    }
    
    public float getSeviceRate() {
        return (100f * ordersServed) / ordersTotal;
    }
    
    @Override
    public String toString() {
        char nl = '\n';
        String bar = "---";
        StringBuilder sb = new StringBuilder();
        sb.append("Orders served: ").append(ordersServed).append(nl)
          .append("Orders total:  ").append(ordersTotal).append(nl)
          .append("Service rate:  ").append(getSeviceRate()).append(nl)
          .append(bar)
          .append("Average wait time:       ").append(averageWaitTime)
                .append(nl)
          .append("Average travel time:     ").append(averageTravelTime)
                .append(nl)
          .append("Average travel distance: ").append(averageTravelDistance)
                .append(nl)
          .append(bar)
          .append("Wait time SD:       ").append(waitTimeStandardDeviation)
                .append(nl)
          .append("Travel time SD:     ").append(travelTimeStandardDeviation)
                .append(nl)
          .append("Travel distance SD: ")
                .append(travelDistanceStandardDeviation);
        return sb.toString();
    }
}
