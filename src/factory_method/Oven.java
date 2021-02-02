package factory_method;

public class Oven {

    public void bake(FoodType foodType)  {
        Bakeable bakeable = BakeableFactory.create(foodType);

        System.out.println("Bake " + bakeable.getName()
                + " at " + bakeable.getTemperature() + " degree temperature" +
                " for " + bakeable.getMinutes() + " minutes.");
    }
}
