package task4;

import java.util.LinkedList;

public class ClientT {
    public String name;
    public LinkedList<String> services;
    public int number;

    public enum Status {
        ACTIVE, BLOCKED
    }
    public Status status;

    public ClientT(String n) {
        services = new LinkedList<String>();
        status = Status.ACTIVE;
        number = 0;
        name = n;
    }

    public void changeStatus(Status s) {
        status = s;
    }
    public void changeNumber(int n) {
        number = n;
    }
    public void addService(String service) {
        services.add(service.toLowerCase());
    }
    public void removeService(String service) {
        services.remove(service);
    }
    public boolean payRecipe(int price) {
        if (price > 200) {
            return false;
        }
        return true;
    }

}
