package abstract_factory;

import abstract_factory.drinks.Drink;
import abstract_factory.factories.DinnerFactory;
import abstract_factory.maindishes.MainDish;
import abstract_factory.salad.Salad;
import abstract_factory.soups.Soup;

public class Cafe {
    private DinnerFactory dinnerFactory;

    public Cafe(DinnerFactory dinnerFactory) {
        this.dinnerFactory = dinnerFactory;
    }

    public void setDinnerFactory(DinnerFactory dinnerFactory) {
        this.dinnerFactory = dinnerFactory;
    }

    void cookDinner() {
        Salad salad = dinnerFactory.createSalad();
        Soup soup = dinnerFactory.createSoup();
        MainDish mainDish = dinnerFactory.createMainDish();
        Drink drink = dinnerFactory.createDrink();

        String result = "Served a dinner with " +
                salad + " as a salad, " +
                soup + " as a soup, " +
                mainDish + " as a main dish, " +
                drink + " as a drink.\n";
        System.out.println(result);
    }
}
