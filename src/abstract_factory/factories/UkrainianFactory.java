package abstract_factory.factories;

import abstract_factory.drinks.Drink;
import abstract_factory.drinks.Kissel;
import abstract_factory.maindishes.KievCutlet;
import abstract_factory.maindishes.MainDish;
import abstract_factory.salad.Salad;
import abstract_factory.salad.Vinegret;
import abstract_factory.soups.Shchi;
import abstract_factory.soups.Soup;

public class UkrainianFactory implements DinnerFactory {

    @Override
    public Drink createDrink() {
        return new Kissel();
    }

    @Override
    public MainDish createMainDish() {
        return new KievCutlet();
    }

    @Override
    public Salad createSalad() {
        return new Vinegret();
    }

    @Override
    public Soup createSoup() {
        return new Shchi();
    }
}
