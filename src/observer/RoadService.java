package observer;

public class RoadService extends Institution {

    public static final int MAX_WIND_SPEED = 14;

    @Override
    public int getMaxWindSpeed() {
        return MAX_WIND_SPEED;
    }
}
