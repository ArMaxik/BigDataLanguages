import java.util.ArrayList;
import java.util.Arrays;

public class Laba2 {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("aa", "bb", "cc", "dd", "aa", "dd", "cc", "aa"));

        System.out.println(Arrays.toString(values.stream().distinct().toArray()));
    }
}
