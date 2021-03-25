package ood.airportboardinggate;


import java.time.LocalDateTime;

public class Flight {
    String flighNo;
    LocalDateTime timeAtGate;
    Type type;
}

enum Type {
    ARRIVAL,
    DEPARTURE
}