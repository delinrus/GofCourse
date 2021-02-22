package proxy;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;

public class CalculatorProxy implements Calculator {

    private final Map<Integer, Operation> cache = new ConcurrentHashMap<>();
    private final Calculator service;

    public CalculatorProxy(Calculator service) {
        this.service = service;
    }

    private int doOperation(int x1, int x2, OperationType operationType, BinaryOperator<Integer> operator) {
        Operation operation = new Operation(x1, x2, operationType);
        int hash = operation.hashCode();

        // Getting result from cache if exists
        if (cache.containsKey(hash)) {
            Operation savedOperation = cache.get(hash);
            if (operation.equals(savedOperation)) {
                return savedOperation.getResult();
            }
        }

        // Delegating operation to the service and saving result to cache
        int result = operator.apply(x1, x2);
        operation.setResult(result);
        cache.put(hash, operation);
        return result;
    }

    @Override
    public int add(int x1, int x2) {
        return doOperation(x1, x2, OperationType.ADD, service::add);
    }

    @Override
    public int divide(int x1, int x2) {
        return doOperation(x1, x2, OperationType.DIVIDE, service::divide);
    }

    @Override
    public int multiply(int x1, int x2) {
        return doOperation(x1, x2, OperationType.MULTIPLY, service::multiply);
    }

    @Override
    public int subtract(int x1, int x2) {
        return doOperation(x1, x2, OperationType.SUBTRACT, service::subtract);
    }

    private enum OperationType {
        ADD,
        DIVIDE,
        MULTIPLY,
        SUBTRACT
    }

    private static class Operation {
        private final int x1;
        private final int x2;
        private final OperationType operationType;
        private int result; // Note: the result field is excluded from hashCode and equals methods


        public Operation(int x1, int x2, OperationType operation) {
            this.x1 = x1;
            this.x2 = x2;
            this.operationType = operation;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Operation)) return false;
            Operation that = (Operation) o;
            return x1 == that.x1 &&
                    x2 == that.x2 &&
                    operationType == that.operationType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, x2, operationType);
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }
}
