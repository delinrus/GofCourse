package builder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static builder.PizzaComponent.*;

public class Pizza {
    private final int cheese;
    private final int bacon;
    private final int pineapples;
    private final int mushrooms;
    private final int seafood;

    public Pizza(Pizza.Builder builder) {
        this.cheese = builder.cheese;
        this.bacon = builder.bacon;
        this.pineapples = builder.pineapples;
        this.mushrooms = builder.mushrooms;
        this.seafood = builder.seafood;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "cheese=" + cheese +
                ", bacon=" + bacon +
                ", pineapples=" + pineapples +
                ", mushrooms=" + mushrooms +
                ", seafood=" + seafood +
                '}';
    }

    public static class Builder {
        private int cheese = 0;
        private int bacon = 0;
        private int pineapples = 0;
        private int mushrooms = 0;
        private int seafood = 0;

        private Map<PizzaComponent, Function<Integer, Builder>> handlerMap = new HashMap<>();

        {
            handlerMap.put(CHEESE, this::withCheese);
            handlerMap.put(BACON, this::withBacon);
            handlerMap.put(PINEAPPLES, this::withPineapples);
            handlerMap.put(MUSHROOMS, this::withMushrooms);
            handlerMap.put(SEAFOOD, this::withSeafood);
        }

        public void addComponent (PizzaComponent pizzaComponent, int value) {
            if (pizzaComponent != null) {
                handlerMap.get(pizzaComponent).apply(value);
            }
        }

        public Builder withCheese(int cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder withBacon(int bacon) {
            this.bacon = bacon;
            return this;
        }

        public Builder withPineapples(int pineapples) {
            this.pineapples = pineapples;
            return this;
        }

        public Builder withMushrooms(int mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Builder withSeafood(int seafood) {
            this.seafood = seafood;
            return this;
        }
    }
}
