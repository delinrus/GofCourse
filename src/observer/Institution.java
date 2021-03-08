package observer;

public abstract class Institution implements EventListener {
    private boolean isOpen = true;

    @Override
    public void notify(Integer windSpeed) {
        if (windSpeed >= getMaxWindSpeed()) {
            close();
        } else {
            open();
        }
    }

    public void close() {
        isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public abstract int getMaxWindSpeed();
}
