public abstract class Surgeon implements IDoctor {
    private void treatWithCare(String person) {
        System.out.println("Я вылечил " + person + " с хирургической точностью");
    }
    
    @Override
    public void treat(String person) {
        treatWithCare(person);
    }
}
