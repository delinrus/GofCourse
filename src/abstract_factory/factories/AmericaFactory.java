package abstract_factory.factories;

import abstract_factory.DinnerFactory;
import abstract_factory.drinks.Cola;
import abstract_factory.drinks.Drink;
import abstract_factory.maindishes.LargeBurger;
import abstract_factory.maindishes.MainDish;
import abstract_factory.salad.EggsSalad;
import abstract_factory.salad.Salad;
import abstract_factory.soups.Soup;
import abstract_factory.soups.TomatoSoup;

public class AmericaFactory implements DinnerFactory {

    @Override
    public Drink createDrink() {
        return new Cola();
    }

    @Override
    public MainDish createMainDish() {
        return new LargeBurger();
    }

    @Override
    public Salad createSalad() {
        return new EggsSalad();
    }

    @Override
    public Soup createSoup() {
        return new TomatoSoup();
    }
}
