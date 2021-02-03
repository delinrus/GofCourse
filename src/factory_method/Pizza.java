package factory_method;

public class Pizza implements Bakeable {

    @Override
    public int getMinutes() {
        return 45;
    }

    @Override
    public int getTemperature() {
        return 180;
    }

    @Override
    public String getName() {
        return "Pizza";
    }
}
