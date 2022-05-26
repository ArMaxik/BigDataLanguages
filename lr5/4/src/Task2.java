import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Task2 {
    public static void main(String[] args) throws Exception {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("out2.txt"), "UTF-8")) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("program.txt")), "UTF-8"))) {
                for (String line; (line = br.readLine()) != null;) {
                    String fLine = line.replaceAll(" +", " ");
                    if (fLine.startsWith(" ")) fLine = fLine.substring(1);

                    if (!fLine.isEmpty()) writer.write(fLine.replaceAll(" +", " ") + "\n");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
                System.exit(0);
            } 

            writer.close();
        }
    }
}