package prototype;

public class Main {
    public static void main(String[] args) {
        Car redCar = createCar(CarType.PASSENGER_CAR, "Red", "FJ153FK");
        Car blueCar = createCar(CarType.PASSENGER_CAR, "Blue", "OE244FK");
        Car track = createCar(CarType.TRUCK, "White", "OF335LE");
        System.out.println(blueCar);
        System.out.println(redCar);
        System.out.println(track);
    }

    public static Car createCar(CarType carType, String color, String number) {
        Car car = CarFactory.createPrototype(carType);
        assert car != null;
        car.setColor(color);
        car.setNumber(number);
        return car;
    }
}
