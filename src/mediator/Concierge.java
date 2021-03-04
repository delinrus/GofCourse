package mediator;

import mediator.consumer_services.FlowerDelivery;
import mediator.consumer_services.RepairService;
import mediator.consumer_services.TaxiService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Concierge implements Mediator {
    List<Occupant> occupants = new ArrayList<>();
    TaxiService taxiService = new TaxiService();
    FlowerDelivery flowerDelivery = new FlowerDelivery();
    RepairService repairService = new RepairService();
    ConcurrentLinkedQueue<Message> queue = new ConcurrentLinkedQueue<>();

    public Concierge() {
        startThread();
    }

    private void startThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                doOtherRoutines();
                if (!queue.isEmpty()) {
                    Message message = queue.poll();
                    message.process();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void doOtherRoutines() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addOccupant(Occupant occupant) {
        occupants.add(occupant);
    }

    @Override
    public void callTaxi(Occupant occupant, String destination) {
        queue.add(() -> {
            String message = occupant.name + " living at " + occupant.address + " wants ot go to " + destination;
            String response = taxiService.orderTaxi(message);
            occupant.notify(response);
        });
    }

    @Override
    public void orderFlowers(Occupant occupant, String flowersType) {
        queue.add(() -> {
            String message = occupant.name + " living at " + occupant.address + " wants to order a bouquet of " + flowersType;
            String response = flowerDelivery.orderFlowers(message);
            occupant.notify(response);
        });
    }

    @Override
    public void callRepairman(Occupant occupant, String typeOfFailure) {
        queue.add(() -> {
            String message = occupant.name + " living at " + occupant.address + " needs to repair " + typeOfFailure;
            String response = repairService.orderRepairing(message);
            occupant.notify(response);
        });
    }

    private interface Message {
        void process();
    }
}
