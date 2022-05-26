import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Laba1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));

        System.out.println(strings.stream().collect(Collectors.joining(":")));
    }
}
