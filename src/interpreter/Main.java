package interpreter;

import command.Pizza;

public class Main {

    public static void main(String[] args) throws Exception {
        String input = "add cheese 150 add bacon 250 add mushrooms 100";
        Expression expression = Interpreter.evaluate(input);
        Pizza pizza = expression.interpret();
        System.out.println(pizza);
    }
}
