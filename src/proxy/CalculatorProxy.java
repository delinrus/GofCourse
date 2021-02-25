package proxy;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;

public class CalculatorProxy implements Calculator {

    Cache<Operation, Integer> cache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();

    private final Calculator service;

    public CalculatorProxy(Calculator service) {
        this.service = service;
    }

    private Integer doOperation(int x1, int x2, OperationType operationType, BinaryOperator<Integer> operator) {
        Operation operation = new Operation(x1, x2, operationType);
        return cache.get(operation, o -> operator.apply(o.getX1(), o.getX2()));
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

        public Operation(int x1, int x2, OperationType operation) {
            this.x1 = x1;
            this.x2 = x2;
            this.operationType = operation;
        }

        public int getX1() {
            return x1;
        }

        public int getX2() {
            return x2;
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
    }
}
