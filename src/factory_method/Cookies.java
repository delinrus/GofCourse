package factory_method;

public class Cookies implements Bakeable {
    @Override
    public int getMinutes() {
        return 25;
    }

    @Override
    public int getTemperature() {
        return 200;
    }

    @Override
    public String getName() {
        return "Cookies";
    }
}
