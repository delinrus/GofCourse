package prototype;

import java.util.Objects;

public class CarImpl extends Car implements CarWide {
    private float maxSpeed;
    private int load;
    private int seats;
    private String engine;
    private String body;
    private String frame;

    public CarImpl(CarImpl target) {
        super(target);
        if (target != null) {
            maxSpeed = target.maxSpeed;
            load = target.load;
            seats = target.seats;
            engine = target.engine;
            body = target.body;
            frame = target.frame;
        }
    }

    public CarImpl() {
        super();
    }

    @Override
    public Car clone() {
        return new CarImpl(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", load=" + load +
                ", seats=" + seats +
                ", engine='" + engine + '\'' +
                ", body='" + body + '\'' +
                ", frame='" + frame + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                '}';
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public CarWide withMaxSpeed(float maxSpeed) {
        setMaxSpeed(maxSpeed);
        return this;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public CarWide withLoad(int load) {
        setLoad(load);
        return this;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public CarWide withSeats(int seats) {
        setSeats(seats);
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public CarWide withEngine(String engine) {
        setEngine(engine);
        return this;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public CarWide withBody(String body) {
        setBody(body);
        return this;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    @Override
    public CarWide withFrame(String frame) {
        setFrame(frame);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarImpl)) return false;
        if (!super.equals(o)) return false;
        CarImpl car = (CarImpl) o;
        return Float.compare(car.maxSpeed, maxSpeed) == 0 &&
                load == car.load &&
                seats == car.seats &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(body, car.body) &&
                Objects.equals(frame, car.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxSpeed, load, seats, engine, body, frame);
    }
}
