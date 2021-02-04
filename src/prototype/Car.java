package prototype;

import java.util.Objects;

public abstract class Car {
    private String color;
    private String number;

    public Car() {
    }

    public Car(Car target) {
        if (target != null) {
            color = target.color;
            number = target.number;
        }
    }

    public abstract Car clone();

    public void setColor(String color) {
        this.color = color;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(color, car.color) &&
                Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, number);
    }
}
