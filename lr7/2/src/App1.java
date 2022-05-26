import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App1 {
    public static void main(String[] args) throws Exception {
        String text = new String(Files.readAllBytes(Paths.get("poem.txt")));
        text = text.replaceAll("\n", " ");

        ArrayList<String> list = new ArrayList<String>();
        for (String word : text.split(" ")) {
            if (word.charAt(0) == word.charAt(word.length() - 1) && !list.contains(word)) list.add(word);
        }

        System.out.println(list);
    }
}
