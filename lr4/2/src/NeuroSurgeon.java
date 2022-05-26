public class NeuroSurgeon extends Surgeon {
    String name;
    
    NeuroSurgeon(String name) {
    }

    @Override
    public void treat(String person) {
        System.out.println("Я вылечил " + person + " с нейрохирургической точностью");
    }
}
