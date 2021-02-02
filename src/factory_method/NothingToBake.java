package factory_method;

public class NothingToBake implements Bakeable{
    @Override
    public int getMinutes() {
        return 0;
    }

    @Override
    public int getTemperature() {
        return 0;
    }

    @Override
    public String getName() {
        return "Nothing";
    }
}
