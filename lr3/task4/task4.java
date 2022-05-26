package task4;

public class task4 {
    public static void main(String[] args) {
        // Task 4.1
        Buro b = new Buro();
        Client c1 = new Client("Ivan");
        int price = b.processTask(c1.makeTask());
        c1.recieveRecipe(price);

        // Task 4.2
        Admin admin = new Admin();
        admin.newClient("Ivan");
        admin.newClient("Ira");
        admin.newClient("Jonny");

        admin.addService(2, "Humor");
        admin.addService(2, "TikTok");
        admin.addService(2, "+1000_SMS");
        admin.makeRecipe(2);
    }
}
