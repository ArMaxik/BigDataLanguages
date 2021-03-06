import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) throws Exception {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("out.txt"), "UTF-8")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("text.txt")), "UTF-8"))) {
                for (String line; (line = br.readLine()) != null;) {
                    ArrayList<String> words = new ArrayList<String>(Arrays.asList(line.split(" ")));
                    ArrayList<String> list = new ArrayList<String>();
    
                    for (String word : words) {
                        if (word.matches("^[a-zA-Z]{3,5}$")) {
                            list.add(word);
                        }
                    }
    
                    System.out.println("Line: " + line + ", detected words: " + list);
    
                    System.out.print("Deleted: ");
                    for (int i = 0; i < list.size() - list.size() % 2; i++) {
                        System.out.print(list.get(i) + " ");
                        words.remove(list.get(i));
                    }

                    System.out.println("\n");

                    writer.write(String.join(" ", words) + "\n");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                System.exit(0);
            } 

            writer.close();
        }
    }
}
