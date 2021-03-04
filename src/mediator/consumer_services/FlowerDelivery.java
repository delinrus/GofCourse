package mediator.consumer_services;

import mediator.Logger;

public class FlowerDelivery {
    public String orderFlowers(String message) {
        Logger.log("Flower delivery got the message: " + message);
        return "Flower service accepted the order";
    }
}
