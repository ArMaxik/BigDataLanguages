import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class App2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("out_text.txt"));

        int rule = Integer.parseInt(args[0]);
        String symbol = args[1];
        int k = 0;

        if (args.length == 3) k = Integer.parseInt(args[2]);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("text.txt")), "UTF-8"))) {
            for (String line; (line = br.readLine()) != null;) {
                switch (rule) {
                    case 0:
                        writer.write(line.replaceAll(symbol, "") + "\n");
                    break;
                
                    default:
                        line = line.substring(0, k) + symbol + line.substring(k);
                        writer.write(line + "\n");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(0);
        } 

        writer.close();
    }
}
