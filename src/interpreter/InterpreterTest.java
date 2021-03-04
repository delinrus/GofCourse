package interpreter;

import command.Pizza;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class InterpreterTest {

    @Test
    public void correctInterpretation() throws Exception {
        String input = "add cheese 150 add bacon 250 add mushrooms 100";
        Pizza pizza = new Pizza();
        Expression expression = Interpreter.evaluate(input);
        expression.interpret(pizza);
        assertEquals("Pizza{cheese=150, bacon=250, pineapples=0, mushrooms=100, seafood=0}", pizza.toString());
    }

    @Test
    public void wrongInterpretation() {
        String input = "1add cheese 150 addd bacon 250";
        Assertions.assertThrows(Exception.class, () -> Interpreter.evaluate(input));
    }
}