package prototype;

import java.util.Objects;

public class CarImpl implements Car, Cloneable  {
    // Production properties
    private float maxSpeed;
    private int load;
    private int seats;
    private String engine;
    private String body;
    private String frame;

    // Client properties
    private String color;
    private String number;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
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
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarImpl car = (CarImpl) o;
        return Float.compare(car.maxSpeed, maxSpeed) == 0 &&
                load == car.load &&
                seats == car.seats &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(body, car.body) &&
                Objects.equals(frame, car.frame) &&
                Objects.equals(color, car.color) &&
                Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxSpeed, load, seats, engine, body, frame, color, number);
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

}
