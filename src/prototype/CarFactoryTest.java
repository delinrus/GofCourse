package prototype;

import org.junit.Test;

import static org.junit.Assert.*;
import static prototype.CarType.PASSENGER_CAR;
import static prototype.CarType.TRUCK;


public class CarFactoryTest {

    @Test
    public void prototypesAreEquals() {
        Car car1 = CarFactory.createPrototype(PASSENGER_CAR);
        Car car2 = CarFactory.createPrototype(PASSENGER_CAR);
        assertEquals(car1, car2);
    }

    @Test
    public void prototypesAreDifferentObjects() {
        Car car1 = CarFactory.createPrototype(PASSENGER_CAR);
        Car car2 = CarFactory.createPrototype(PASSENGER_CAR);
        assertNotSame(car1, car2);
    }

    @Test
    public void settingNumberAndColor() {
        Car car = CarFactory.createPrototype(TRUCK);
        assertNotNull(car);
        car.setColor("White");
        car.setNumber("EI352KE");
        assertEquals("Car{maxSpeed=90.0, load=4000, seats=2, engine='VX-4'," +
                " body='FZ-50', frame='JL-45', color='White', number='EI352KE'}", car.toString());
    }
}