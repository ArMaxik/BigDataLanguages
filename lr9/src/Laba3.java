import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Laba3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.println(list.stream().filter(i -> i % 2 == 0).reduce(0, (a, b) -> a + b));
    }
}
