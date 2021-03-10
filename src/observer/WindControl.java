package observer;

import java.util.ArrayList;
import java.util.List;

public class WindControl {
    private List<EventListener> listeners = new ArrayList<>();

    public List<EventListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<EventListener> listeners) {
        this.listeners = listeners;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
        notifyListeners();
    }

    private Integer windSpeed;

    public void subscribe(EventListener eventListener) {
        if (eventListener != null) {
            listeners.add(eventListener);
        }
    }

    public void unsubscribe(EventListener eventListener) {
        if (eventListener != null) {
            listeners.remove(eventListener);
        }
    }

    public void notifyListeners() {
        listeners.forEach(eventListener -> eventListener.notify(windSpeed));
    }
}
