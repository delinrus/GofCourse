package state;

public class Oven {
    private State state;
    private int temperature;
    private boolean isBaking = false;

    public static final int BAKE_MIN_TEMPERATURE = 200;
    public static final int BAKE_MAX_TEMPERATURE = 230;

    public Oven(int temperature) {
        this.temperature = temperature;
        changeState();
    }

    public void bake() throws Exception {
        state.bake();
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        changeState();
    }

    public void changeState() {
        if (temperature < BAKE_MIN_TEMPERATURE) {
            state = new Cool();
        } else if (temperature > BAKE_MAX_TEMPERATURE) {
            state = new Overheated();
        } else {
            state = new Ready();
        }
    }

    public boolean isBaking() {
        return isBaking;
    }

    private void setBaking(boolean baking) {
        isBaking = baking;
    }

    private interface State {
        void bake() throws Exception;
    }

    private class Cool implements State {
        @Override
        public void bake() throws Exception {
            throw new Exception("Oven is to cool to bake");
        }
    }

    private class Ready implements State {
        @Override
        public void bake() {
            setBaking(true);
        }
    }

    private class Overheated implements State {
        @Override
        public void bake() throws Exception {
            throw new Exception("Oven is overheated and can't bake.");
        }
    }
}
