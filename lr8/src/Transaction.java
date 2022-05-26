import java.util.Random;

public class Transaction {
    final int id;
    final String from;
    final String to;
    final int count;

    public Transaction(String from, String to, int count) {
        Random random = new Random();

        this.id = random.nextInt(random.nextInt(1000) + 1000);
        this.from = from;
        this.to = to;
        this.count = count;
    }
}
