package observer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindControlTest {

    WindControl windControl;
    School school;
    RoadService roadService;
    Airport airport;

    @Before
    public void setUp() {
        windControl = new WindControl();

        school = new School();
        roadService = new RoadService();
        airport = new Airport();

        windControl.subscribe(school);
        windControl.subscribe(roadService);
        windControl.subscribe(airport);

        assertTrue(airport.isOpen());
        assertTrue(roadService.isOpen());
        assertTrue(school.isOpen());
    }

    @Test
    public void closeAirportLevel() {
        windControl.setWindSpeed(Airport.MAX_WIND_SPEED);
        assertFalse(airport.isOpen());
    }

    @Test
    public void notAffectWhenUnsubscribed() {
        windControl.unsubscribe(airport);
        windControl.setWindSpeed(Airport.MAX_WIND_SPEED);
        assertTrue(airport.isOpen());
    }

    @Test
    public void openAirportLevel() {
        windControl.setWindSpeed(Airport.MAX_WIND_SPEED - 1);
        assertTrue(airport.isOpen());
    }

    @Test
    public void affectAllListeners() {
        int maxWindSpeed = Math.max(airport.getMaxWindSpeed(),
                Math.max(school.getMaxWindSpeed(), roadService.getMaxWindSpeed()));

        windControl.setWindSpeed(maxWindSpeed);
        assertFalse(airport.isOpen());
        assertFalse(roadService.isOpen());
        assertFalse(school.isOpen());
    }
}