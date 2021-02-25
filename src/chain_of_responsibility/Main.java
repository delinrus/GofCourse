package chain_of_responsibility;

public class Main {

    public static void main(String[] args) {
        EmergencyService service = new FirefightingService(() -> System.out.println("Firefighters in action"));
        service.linkWith(new MedicalService(() -> System.out.println("Medics in action")))
                .linkWith( new PoliceService(() -> System.out.println("Police in action")));

        handleQuery(service, "There is a riot in the city center, some people could get injury");
        handleQuery(service, "Anonymous call reported smoke in the old warehouse");
    }

    private static void handleQuery(EmergencyService service, String query) {
        System.out.println("Handling query: " + query);
        service.check(query);
        System.out.println();
    }
}
