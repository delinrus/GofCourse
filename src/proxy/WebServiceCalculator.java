package proxy;

import facade.CalculatorFacade;

public class WebServiceCalculator implements Calculator  {
    @Override
    public int add(int x1, int x2) {
        try {
            return CalculatorFacade.add(x1, x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int divide(int x1, int x2) {
        try {
            return CalculatorFacade.divide(x1, x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int multiply(int x1, int x2) {
        try {
            return CalculatorFacade.multiply(x1, x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int subtract(int x1, int x2) {
        try {
            return CalculatorFacade.subtract(x1, x2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
