package prototype;

public interface CarWide {
    float getMaxSpeed();

    void setMaxSpeed(float maxSpeed);

    CarWide withMaxSpeed(float maxSpeed);

    int getLoad();

    void setLoad(int load);

    CarWide withLoad(int load);

    int getSeats();

    void setSeats(int seats);

    CarWide withSeats(int seats);

    String getEngine();

    void setEngine(String engine);

    CarWide withEngine(String engine);

    String getBody();

    void setBody(String body);

    CarWide withBody(String body);

    String getFrame();

    void setFrame(String frame);

    CarWide withFrame(String frame);
}
