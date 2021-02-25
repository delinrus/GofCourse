package chain_of_responsibility;

import java.util.Arrays;
import java.util.List;

public class MedicalService extends EmergencyService {

    private final Runnable action;

    public MedicalService(Runnable action) {
        this.action = action;
    }

    @Override
    public void action() {
        action.run();
    }

    @Override
    public List<String> getCauses() {
        return Arrays.asList("injury", "heart attack");
    }
}
