package state;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class OvenTest {

    @Test
    public void minTemperatureBaking() throws Exception {
        Oven oven = new Oven(Oven.BAKE_MIN_TEMPERATURE);
        assertFalse(oven.isBaking());
        oven.bake();
        assertTrue(oven.isBaking());
    }

    @Test
    public void maxTemperatureBaking() throws Exception {
        Oven oven = new Oven(Oven.BAKE_MAX_TEMPERATURE);
        assertFalse(oven.isBaking());
        oven.bake();
        assertTrue(oven.isBaking());
    }

    @Test
    public void setTemperatureInsideTemperatureRage() throws Exception {
        Oven oven = new Oven(Oven.BAKE_MAX_TEMPERATURE);
        oven.setTemperature(Oven.BAKE_MAX_TEMPERATURE - 1);
        oven.bake();
        assertTrue(oven.isBaking());
    }

    @Test
    public void overheated() {
        Oven oven = new Oven(Oven.BAKE_MAX_TEMPERATURE);
        oven.setTemperature(Oven.BAKE_MAX_TEMPERATURE + 1);
        Exception thrown = Assertions.assertThrows(Exception.class, oven::bake);
        assertEquals("Oven is overheated and can't bake.",thrown.getMessage());
    }

    @Test
    public void cool() {
        Oven oven = new Oven(Oven.BAKE_MAX_TEMPERATURE);
        oven.setTemperature(Oven.BAKE_MIN_TEMPERATURE - 1);
        Exception thrown = Assertions.assertThrows(Exception.class, oven::bake);
        assertEquals("Oven is to cool to bake",thrown.getMessage());
    }
}