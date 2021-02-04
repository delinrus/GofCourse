package prototype;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static prototype.CarType.*;

@RunWith(Parameterized.class)
public class CarFactoryAllCarsTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {PASSENGER_CAR, "Car{maxSpeed=160.0, load=2000, seats=4, engine='VX-4', body='FZ-50', frame='JL-45', color='null', number='null'}"},
                {TRUCK, "Car{maxSpeed=90.0, load=4000, seats=2, engine='VX-4', body='FZ-50', frame='JL-45', color='null', number='null'}"},
                {MINIVAN, "Car{maxSpeed=110.0, load=750, seats=8, engine='VX-18', body='FR-34', frame='JD-84', color='null', number='null'}"}
        });
    }

    @Parameterized.Parameter()
    public CarType carType;

    @Parameterized.Parameter(1)
    public String expected;


    @Test
    public void settingNumberAndColor() {
        Car car = CarFactory.createPrototype(carType);
        assertNotNull(car);
        assertEquals(expected, car.toString());
    }

}
