package abstract_factory;

import abstract_factory.factories.AmericaFactory;
import abstract_factory.factories.JapaneseFactory;
import abstract_factory.factories.UkrainianFactory;

public class Main {
    public static void main(String[] args) {
        Cafe cafe = new Cafe(new JapaneseFactory());
        cafe.cookDinner();

        cafe.setDinnerFactory(new UkrainianFactory());
        cafe.cookDinner();

        cafe.setDinnerFactory(new AmericaFactory());
        cafe.cookDinner();
    }
}
