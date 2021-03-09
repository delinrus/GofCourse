package mediator;

public interface Mediator {
    void callTaxi(Occupant occupant, String destination);
    void orderFlowers(Occupant occupant, String flowersType);
    void callRepairman(Occupant occupant, String typeOfFailure);
}
