package facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorFacadeTest {

    @Test
    public void add() throws Exception {
        assertEquals(11, CalculatorFacade.add(4,7));
    }

    @Test
    public void divide() throws Exception {
        assertEquals(6, CalculatorFacade.divide(30,5));
    }

    @Test
    public void multiply() throws Exception {
        assertEquals(18, CalculatorFacade.multiply(2,9));
    }

    @Test
    public void subtract() throws Exception {
        assertEquals(-13, CalculatorFacade.subtract(10,23));
    }
}