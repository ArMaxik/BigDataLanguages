import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App1 {
    public static void main(String[] args) throws Exception {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        
        String suffix = args[0]; // То, что заменяем
        String change = args[1]; // То, на что заменяем

        Matcher m = Pattern.compile(suffix + "[ .,!?:;]").matcher(text);

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (m.find()) {
            list.add(m.end() - 1);
        }

        Collections.reverse(list);

        for (int idx : list) {
            text = text.substring(0, idx) + change + text.substring(idx);
        }

        System.out.println(text);
    }
}
 