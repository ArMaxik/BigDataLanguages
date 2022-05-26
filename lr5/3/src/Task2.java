import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String fileLocation = "poem2.txt";

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("poem2_out.txt"), "UTF-8")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileLocation)), "UTF-8"))) {
                for (String line; (line = br.readLine()) != null;) {
                    String[] words = line.split(" ");
                    ArrayList<String> list = new ArrayList<String>();
    
                    for (String word : words) {
                        if (word.length() > 1) {
                            String newWord = word.substring(0, 1).toUpperCase() + word.substring(1);
                            list.add(newWord);
                        }
                        else list.add(word.toUpperCase());
                    }
    
                    writer.write(list.stream().map(Object::toString).collect(Collectors.joining(" ")) + "\n");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                System.exit(0);
            } 
    
            writer.close();
        }
    }
}
