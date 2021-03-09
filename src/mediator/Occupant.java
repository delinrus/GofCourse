package mediator;

public class Occupant implements Subscriber {

    public String address;
    public String name;
    public Mediator mediator;

    public Occupant(String name, String address, Mediator mediator) {
        this.name = name;
        this.address = address;
        this.mediator = mediator;
    }

    public void callTaxi(String destination) {
        mediator.callTaxi(this, destination);
    }

    public void orderFlowers(String flowersType) {
        mediator.orderFlowers(this, flowersType);
    }

    public void callRepairman(String typeOfFailure) {
        mediator.callRepairman(this, typeOfFailure);
    }

    @Override
    public void notify(String message) {
        Logger.log("Occupant " + name + " got the message: " + message);
    }
}
