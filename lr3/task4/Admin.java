package task4;

import java.util.LinkedList;

public class Admin {
    static int lastnumer = 0;
    public LinkedList<ClientT> clients;

    public Admin() {
        clients = new LinkedList<ClientT>();
    }

    public void newClient(String name) {
        ClientT c = new ClientT(name);
        c.addService("SMS");
        c.addService("MMS");
        c.addService("Inernet");
        c.changeNumber(lastnumer);
        lastnumer += 1;
        clients.add(c);
    }
    public void banClient(int number) {
        for (ClientT c : clients) {
            if (c.number == number) {
                c.changeStatus(ClientT.Status.BLOCKED);
            }
        }
    }
    public void unBanClient(int number) {
        for (ClientT c : clients) {
            if (c.number == number) {
                c.changeStatus(ClientT.Status.ACTIVE);
            }
        }
    }
    public void changePhone(int number, int newNumber) {
        for (ClientT c : clients) {
            if (c.number == number) {
                c.changeNumber(newNumber);
            }
        }
    }
    public void addService(int number, String s) {
        for (ClientT c : clients) {
            if (c.number == number) {
                c.addService(s);
            }
        }
    }
    public void removeService(int number, String s) {
        for (ClientT c : clients) {
            if (c.number == number) {
                c.removeService(s);
            }
        }
    }
    public void makeRecipe(int number) {
        for (ClientT c : clients) {
            if (c.number == number) {
                int price = c.services.size() * 100;
                if (!c.payRecipe(price)) {
                    banClient(number);
                }
            }
        }
    }

}
