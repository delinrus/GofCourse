package factory_method;

public class Fish implements Bakeable {
    @Override
    public int getMinutes() {
        return 50;
    }

    @Override
    public int getTemperature() {
        return 200;
    }

    @Override
    public String getName() {
        return "Fish";
    }
}
