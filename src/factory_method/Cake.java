package factory_method;

public class Cake implements Bakeable {
    @Override
    public int getMinutes() {
        return 30;
    }

    @Override
    public int getTemperature() {
        return 190;
    }

    @Override
    public String getName() {
        return "Cake";
    }
}
