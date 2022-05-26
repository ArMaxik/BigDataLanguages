import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws Exception {
        String fileLocation = "poem.txt";
        Pattern pattern = Pattern.compile("[а-яА-Я]{1,}");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileLocation)), "UTF-8"))) {
            for (String line; (line = br.readLine()) != null;) {
                if (!line.isEmpty()) {
                    System.out.println(line);
                    
                    line = line.toLowerCase();
                    HashMap<String, Integer> map = new HashMap<String, Integer>();
                    for (String arg : args) map.put(arg, 0);

                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String word = matcher.group();
                        if (Arrays.stream(args).anyMatch(word::equals)) map.put(word, map.get(word) + 1);
                    }

                    map = map.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                    System.out.println(map);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        } 
    }
}
