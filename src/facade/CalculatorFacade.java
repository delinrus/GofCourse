package facade;

import facade.web_service_calculator.wsCalculatorAdd;
import facade.web_service_calculator.wsCalculatorDivide;
import facade.web_service_calculator.wsCalculatorMultiply;
import facade.web_service_calculator.wsCalculatorSubtract;

public class CalculatorFacade {

    public static int add(int x1, int x2) throws Exception {
        return new wsCalculatorAdd().doOperation(x1, x2);
    }

    public static int divide(int x1, int x2) throws Exception {
        return new wsCalculatorDivide().doOperation(x1, x2);
    }

    public static int multiply(int x1, int x2) throws Exception {
        return new wsCalculatorMultiply().doOperation(x1, x2);
    }

    public static int subtract(int x1, int x2) throws Exception {
        return new wsCalculatorSubtract().doOperation(x1, x2);
    }
}
