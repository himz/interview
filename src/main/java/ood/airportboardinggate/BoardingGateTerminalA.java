package ood.airportboardinggate;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BoardingGateTerminalA implements BoardingGate {
    String id;
    List<Airline> airlines= new ArrayList<>();  // all the subscriber to be instantiated here
    PriorityQueue<Flight> flights = new PriorityQueue<>((a,b) -> {
        if(a.timeAtGate.isBefore(b.timeAtGate))
            return -1;
        else
            return 1;
    });

    @Override
    public List<Airline> getAirlines() {
        return airlines;
    }

    @Override
    public String getId() {
        return id;
    }

    public void allocateFlight(Flight flight) {

    }

    public Flight getNextFlight() {
        return flights.peek();
    }

    @Override
    public boolean boardPassenger(BoardingPass pass) {
        return false;
    }
}
