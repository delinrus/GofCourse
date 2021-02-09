package builder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static builder.PizzaComponent.*;

public class Pizza {
    private int cheese;
    private int bacon;
    private int pineapples;
    private int mushrooms;
    private int seafood;

    private Pizza(){
    }

    public static Pizza.Builder newBuilder() {
        return new Pizza().new Builder();
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

    public class Builder {

        private Map<PizzaComponent, Function<Integer, Builder>> handlerMap = new HashMap<>();

        {
            handlerMap.put(CHEESE, this::withCheese);
            handlerMap.put(BACON, this::withBacon);
            handlerMap.put(PINEAPPLES, this::withPineapples);
            handlerMap.put(MUSHROOMS, this::withMushrooms);
            handlerMap.put(SEAFOOD, this::withSeafood);
        }

        public Pizza build() {
            return Pizza.this;
        }

        public void addComponent (PizzaComponent pizzaComponent, int value) {
            if (pizzaComponent != null) {
                handlerMap.get(pizzaComponent).apply(value);
            }
        }

        public Builder withCheese(int cheese) {
            Pizza.this.cheese = cheese;
            return this;
        }

        public Builder withBacon(int bacon) {
            Pizza.this.bacon = bacon;
            return this;
        }

        public Builder withPineapples(int pineapples) {
            Pizza.this.pineapples = pineapples;
            return this;
        }

        public Builder withMushrooms(int mushrooms) {
            Pizza.this.mushrooms = mushrooms;
            return this;
        }

        public Builder withSeafood(int seafood) {
            Pizza.this.seafood = seafood;
            return this;
        }
    }
}
