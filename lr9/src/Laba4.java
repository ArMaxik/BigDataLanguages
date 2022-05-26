import java.util.ArrayList;
import java.util.Arrays;

public class Laba4 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(100.0, 50.0, 150.0, 70.0, 60.0, 20.0, 30.0));

        System.out.println(list.stream().mapToDouble(x -> x - 10.0).average());
    }
}
