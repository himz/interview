package ood.airportboardinggate;

import java.util.ArrayList;
import java.util.List;

public interface BoardingGate {
    // Subscriptions
    List<Airline> getAirlines();
    String getId();
    void allocateFlight(Flight flight);
    Flight getNextFlight();

    /**
     * Check boarding pass of the passenger, match with flight
     * and return wheter passenger will be allowed or not.
     * if allowed, board.
     * @param pass
     * @return
     */
    boolean boardPassenger(BoardingPass pass);


}
