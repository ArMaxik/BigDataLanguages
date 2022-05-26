package task4;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

class RandomString{
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    static String generate(int max){
        Random rnd = new Random();
        int len = rnd.nextInt(max - 10) + 10;
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
public class Client {
    String name;
    public Client(String name) {
        this.name = name;
    }
    public String makeTask() {
        return RandomString.generate(25);
    }

    public String recieveRecipe(int price) {
        return "I will pay!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client c = (Client) o;
        return name.equals(c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Client {name:" + name + "}";
    }

}
