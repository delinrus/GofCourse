package mediator.consumer_services;

import mediator.Logger;

public class RepairService {
    public String orderRepairing(String message) {
        Logger.log("Repair service got the message: " + message);
        return "Repair service accepted the order";
    }
}
