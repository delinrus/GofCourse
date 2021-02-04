package prototype;

import java.util.HashMap;
import java.util.Map;

import static prototype.CarType.*;

public class CarFactory {
    private static final CarWide minivan = new CarImpl();
    private static final CarWide truck = new CarImpl();
    private static final CarWide passengerCar = new CarImpl();
    private static final Map<CarType, CarWide> carMap = new HashMap<>();

    static {
        minivan.withBody("FR-34")
            .withEngine("VX-18")
            .withFrame("JD-84")
            .withLoad(750)
            .withMaxSpeed(110)
            .withSeats(8);

        truck.withBody("FZ-50")
            .withEngine("VX-4")
            .withFrame("JL-45")
            .withLoad(4000)
            .withMaxSpeed(90)
            .withSeats(2);

        passengerCar.withBody("FZ-50")
            .withEngine("VX-4")
            .withFrame("JL-45")
            .withLoad(2000)
            .withMaxSpeed(160)
            .withSeats(4);

        carMap.put(MINIVAN, minivan);
        carMap.put(TRUCK, truck);
        carMap.put(PASSENGER_CAR, passengerCar);
    }

    public static Car createPrototype(CarType carType) {
        CarWide car = carMap.get(carType);
        if (car == null) {
            return null;
        }
        return ((Car)car).clone();
    }
}
