import java.util.Random;
import java.util.UUID;

public class Account extends Thread {
    String name;
    int moneyCount;
    Boolean hasChanged;

    Account() {
        Random random = new Random();
        this.name = UUID.randomUUID().toString().substring(0, 4);
        this.moneyCount = random.nextInt(100000) + 100000;
        this.hasChanged = false;
    }

    public int increase(int count) {
        this.hasChanged = true;

        return moneyCount += count;
    }

    public int decrease(int count) {
        this.hasChanged = true;

        return moneyCount -= count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);

                if (hasChanged) {
                    System.out.println("Счет " + this.name + " стал равен " + moneyCount);
                    hasChanged = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "[" + name + "]: " + moneyCount;
    }
}
