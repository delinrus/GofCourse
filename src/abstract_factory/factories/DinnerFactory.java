package abstract_factory.factories;

import abstract_factory.drinks.Drink;
import abstract_factory.maindishes.MainDish;
import abstract_factory.salad.Salad;
import abstract_factory.soups.Soup;

public interface DinnerFactory {
    Drink createDrink();

    MainDish createMainDish();

    Salad createSalad();

    Soup createSoup();
}
