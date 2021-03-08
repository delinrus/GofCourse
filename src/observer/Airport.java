package observer;

public class Airport extends Institution {

    public static final int MAX_WIND_SPEED = 12;

    @Override
    public int getMaxWindSpeed() {
        return MAX_WIND_SPEED;
    }
}
