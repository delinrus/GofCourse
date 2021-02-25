package proxy;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorProxyTest {

    private static final int ADD_RESULT = 15;

    @Test
    public void integrationTest() {
        Calculator webServiceCalculator = new WebServiceCalculator();
        Calculator calculatorProxy = new CalculatorProxy(webServiceCalculator);
        assertEquals(11, calculatorProxy.add(4, 7));
        assertEquals(6, calculatorProxy.divide(30, 5));
        assertEquals(18, calculatorProxy.multiply(2, 9));
        assertEquals(-13, calculatorProxy.subtract(10, 23));
    }

    @Test
    public void sameResult() {
        FakeCalculator fakeCalculator = new FakeCalculator();
        Calculator calculatorProxy = new CalculatorProxy(fakeCalculator);
        assertEquals(ADD_RESULT, calculatorProxy.add(10, 5));
        assertEquals(ADD_RESULT, calculatorProxy.add(10, 5));
    }

    @Test
    public void cachedOperationCalledOnlyOnce() {
        FakeCalculator fakeCalculator = new FakeCalculator();
        Calculator calculatorProxy = new CalculatorProxy(fakeCalculator);
        calculatorProxy.add(10, 5);
        calculatorProxy.add(10, 5);
        assertEquals(1, fakeCalculator.getInvocationsCount());
    }

    private static class FakeCalculator implements Calculator {

        public int getInvocationsCount() {
            return invocationsCount;
        }

        private int invocationsCount = 0;

        @Override
        public int add(int x1, int x2) {
            invocationsCount++;
            return ADD_RESULT;
        }

        @Override
        public int divide(int x1, int x2) {
            invocationsCount++;
            return 0;
        }

        @Override
        public int multiply(int x1, int x2) {
            invocationsCount++;
            return 0;
        }

        @Override
        public int subtract(int x1, int x2) {
            invocationsCount++;
            return 0;
        }
    }
}