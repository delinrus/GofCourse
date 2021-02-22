package chain_of_responsibility;

import java.util.Arrays;
import java.util.List;

public class PoliceService extends EmergencyService {

    private final Runnable action;

    public PoliceService(Runnable action) {
        this.action = action;
    }

    @Override
    public void action() {
        action.run();
    }

    @Override
    public List<String> getCauses() {
        return Arrays.asList("robbery", "riot");
    }
}
