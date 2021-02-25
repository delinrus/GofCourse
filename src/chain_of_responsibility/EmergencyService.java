package chain_of_responsibility;

import java.util.List;

public abstract class EmergencyService {

    private EmergencyService next;

    public EmergencyService linkWith(EmergencyService next) {
        this.next = next;
        return next;
    }

    public boolean check(String query) {
        query = query.toLowerCase();

        for (String cause : getCauses()) {
            if (query.contains(cause)) {
                action();
            }
        }
        return checkNext(query);
    }

    protected boolean checkNext(String query) {
        if (next == null) {
            return true;
        }
        return next.check(query);
    }

    public abstract void action();

    public abstract List<String> getCauses();
}
