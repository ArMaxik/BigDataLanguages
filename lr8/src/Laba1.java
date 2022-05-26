import java.util.Scanner;

public class Laba1 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.start();

        Supplier supplier = new Supplier(shop);
        supplier.start();

        Scanner in = new Scanner(System.in);
        String command;

        do {
            command = in.nextLine();

            if ("weapons".equals(command)) shop.viewStock();
            if (command.startsWith("order")) {
                String[] splitted = command.split(" ");
                shop.makeOrder(new Order(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2])));
            }

        } while (!"exit".equals(command));

        in.close();

        shop.stop();
        supplier.stop();
    }
}