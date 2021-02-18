package facade;

import facade.web_service_calculator.WsCalculatorAdd;
import facade.web_service_calculator.WsCalculatorDivide;
import facade.web_service_calculator.WsCalculatorMultiply;
import facade.web_service_calculator.WsCalculatorSubtract;

public class CalculatorFacade {

    private static final WsCalculatorAdd addAction = new WsCalculatorAdd();
    private static final WsCalculatorDivide divideAction = new WsCalculatorDivide();
    private static final WsCalculatorMultiply multiplyAction = new WsCalculatorMultiply();
    private static final WsCalculatorSubtract subtractAction = new WsCalculatorSubtract();


    public static int add(int x1, int x2) throws Exception {
        return addAction.doOperation(x1, x2);
    }

    public static int divide(int x1, int x2) throws Exception {
        return divideAction.doOperation(x1, x2);
    }

    public static int multiply(int x1, int x2) throws Exception {
        return multiplyAction.doOperation(x1, x2);
    }

    public static int subtract(int x1, int x2) throws Exception {
        return subtractAction.doOperation(x1, x2);
    }
}
