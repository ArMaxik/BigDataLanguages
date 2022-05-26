import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App2 {
    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("text.txt")));
        text = text.replaceAll("\n", " ");
        Matcher m = Pattern.compile("[^A-z][A-z]+[^A-z]").matcher(text);

        int minLen = 99999;
        int maxLen = 0;

        while (m.find()) {
            String word = m.group().replaceAll("[ .,!?;:\n]", "");

            if (word.length() < minLen) minLen = word.length();
            if (word.length() > maxLen) maxLen = word.length();
        }

        Matcher mMin = Pattern.compile("[^A-z][A-z]{" + minLen + "}[^A-z]").matcher(text);
        Matcher mMax = Pattern.compile("[^A-z][A-z]{" + maxLen + "}[^A-z]").matcher(text);

        ArrayList<String> listMin = new ArrayList<String>();
        ArrayList<String> listMax = new ArrayList<String>();

        while (mMin.find()) {
            String word = mMin.group().replaceAll("[ .,!?;:\n]", "");;
            if (!listMin.contains(word)) listMin.add(word);
        }

        while (mMax.find()) {
            String word = mMax.group().replaceAll("[ .,!?;:\n]", "");;
            if (!listMax.contains(word)) listMax.add(word);
        }

        System.out.println(listMin);
        System.out.println(listMax);
    }
}
