import java.util.Random;

public class Supplier extends Thread {
    private Shop shop;

    Supplier(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (true) {
                Thread.sleep(3000);
                
                shop.sendWeapon(random.nextInt(9));
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
