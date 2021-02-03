package prototype;

import java.util.HashMap;
import java.util.Map;

import static prototype.CarType.*;

public class CarFactory {
    private static final CarImpl minivan = new CarImpl();
    private static final CarImpl truck = new CarImpl();
    private static final CarImpl passengerCar = new CarImpl();
    private static final Map<CarType, CarImpl> carMap = new HashMap<>();

    static {
        minivan.setBody("FR-34");
        minivan.setEngine("VX-18");
        minivan.setFrame("JD-84");
        minivan.setLoad(750);
        minivan.setMaxSpeed(110);
        minivan.setSeats(8);

        truck.setBody("FZ-50");
        truck.setEngine("VX-4");
        truck.setFrame("JL-45");
        truck.setLoad(4000);
        truck.setMaxSpeed(90);
        truck.setSeats(2);

        passengerCar.setBody("FZ-50");
        passengerCar.setEngine("VX-4");
        passengerCar.setFrame("JL-45");
        passengerCar.setLoad(2000);
        passengerCar.setMaxSpeed(160);
        passengerCar.setSeats(4);

        carMap.put(MINIVAN, minivan);
        carMap.put(TRUCK, truck);
        carMap.put(PASSENGER_CAR, passengerCar);
    }

    public static Car createPrototype(CarType carType) {
        CarImpl car = carMap.get(carType);
        if (car == null) {
            return null;
        }
        return (Car) car.clone();
    }
}
