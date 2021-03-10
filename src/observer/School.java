package observer;

public class School extends Institution {

    public static final int MAX_WIND_SPEED = 17;

    @Override
    public int getMaxWindSpeed() {
        return MAX_WIND_SPEED;
    }
}
