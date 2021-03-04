package mediator.consumer_services;

import mediator.Logger;

public class TaxiService {
    public String orderTaxi(String message) {
        Logger.log("Taxi service got a message: " + message);
        return "Taxi service accepted the order";
    }
}
