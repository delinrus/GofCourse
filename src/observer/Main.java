package observer;

public class Main {
    public static void main(String[] args) {
        WindControl windControl = new WindControl();

        School school = new School();
        RoadService roadService = new RoadService();
        Airport airport = new Airport();

        windControl.subscribe(school);
        windControl.subscribe(roadService);
        windControl.subscribe(airport);

        windControl.setWindSpeed(15);
    }
}
