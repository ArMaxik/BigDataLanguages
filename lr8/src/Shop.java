import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Shop extends Thread {
    BlockingQueue<Order> orders;
    ArrayList<Weapon> weaponStock;

    final String[] weapons = {
        "2-дюймовый миномёт",
        "10 cm K 14",
        "Type-97",
        "7,5 cm KwK 37",
        "AK-12",
        "3М6 \"Шмель\"",
        "8-дюймовая гаубица Mark I — V",
        "T-34",
        "Jagdpanzer 38"
    };

    Integer[] weaponCount = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    Shop() {
       weaponStock = new ArrayList<Weapon>();
       orders = new LinkedBlockingDeque<Order>();
    }

    public void sendWeapon(int id) {
        weaponCount[id]++;

        System.out.println("В магазине появилось: " + weapons[id]);
    }

    public void viewStock() {
        for (int i = 0; i < weapons.length; i++) {
            System.out.println("[" + i + "] (" + weapons[i] + "), кол-во: " + weaponCount[i]);
        }
    }

    private void sell(int id, int count) {
        if (id < weapons.length) {
            if (weaponCount[id] >= count) {
                weaponCount[id] -= count;

                System.out.println(weapons[id] + " (" + count + ")" + " успешно приобретен! Поздравляем с покупкой!");
            }
            else {
                System.out.println("Товара [" + weapons[id] + "] недостаточно на складе");
            }
        }
        else {
            System.out.println("Неверный ID товара");
        }
    }

    public void makeOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);

                while (orders.size() > 0) {
                    Order order = orders.take();
                    sell(order.id, order.count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
