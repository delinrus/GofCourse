package abstract_factory.factories;

import abstract_factory.DinnerFactory;
import abstract_factory.drinks.Drink;
import abstract_factory.drinks.GreenTee;
import abstract_factory.maindishes.MainDish;
import abstract_factory.maindishes.Sushi;
import abstract_factory.salad.Salad;
import abstract_factory.salad.Sunomono;
import abstract_factory.soups.Ramen;
import abstract_factory.soups.Soup;

public class JapaneseFactory implements DinnerFactory {
    @Override
    public Drink createDrink() {
        return new GreenTee();
    }

    @Override
    public MainDish createMainDish() {
        return new Sushi();
    }

    @Override
    public Salad createSalad() {
        return new Sunomono();
    }

    @Override
    public Soup createSoup() {
        return new Ramen();
    }
}
