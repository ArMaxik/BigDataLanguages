import java.util.ArrayList;
import java.util.Random;

public class L1_6 {
    public static void main(String[] args) throws Exception {
        Random random = new Random();

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) list.add(random.nextInt(11) - 5);

        System.out.println("Исходный список: " + list);

        for (Integer num : new ArrayList<Integer>(list)) {
            if (num < 0) {
                list.remove(num);
                list.add(num);
            }
        }

        System.out.println("Список после сортировки: " + list);
    }
}
