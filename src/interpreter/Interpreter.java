package interpreter;

import command.PizzaComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final String REGEX = "add\\s([a-z]+)\\s(\\d+)";

    private static boolean isInputCorrect(String input) {
        String[] split = input.split(REGEX);
        for (String s : split) {
            if (!s.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static Expression evaluate(String input) throws Exception {
        if (!isInputCorrect(input)) {
            throw new Exception("Wrong input");
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        MultiExpression multiExpression = new MultiExpression();

        while (matcher.find()) {
            PizzaComponent component = PizzaComponent.valueOf(matcher.group(1).toUpperCase());
            Integer value = Integer.parseInt(matcher.group(2));
            Expression expression = new TerminalExpression(component, value);
            multiExpression.add(expression);
        }
        return multiExpression;
    }
}
