package mediator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Concierge concierge = new Concierge();

        Occupant occupant1 = new Occupant("Dmitry", "apartment 17", concierge);
        Occupant occupant2 = new Occupant("Maxim", "apartment 51", concierge);

        concierge.addOccupant(occupant1);
        concierge.addOccupant(occupant2);

        occupant1.callTaxi("Downing st. 14");
        occupant2.orderFlowers("roses");
        occupant2.callRepairman("broken window");

        Thread.sleep(3000);
    }
}
