import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L6_3 {

    static String parseLine(Line line) {
        return line.axis == null ? "y = " + line.k + "x + " + line.b : line.axis + " = " + line.axisValue;
    }

    public static void main(String[] args) throws Exception {
        String filePath = System.getProperty("user.dir") + "\\src\\dots.txt";
        
        ArrayList<Dot> dotsList = new ArrayList<Dot>();
        HashMap<Line, HashSet<Dot>> lines = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for (String line; (line = br.readLine()) != null;) {
                String[] vals = line.split(" ");

                Dot dot = new Dot(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
                dotsList.add(dot);
            }
        } catch (Exception e) {
            System.out.println("Файл куда-то делся :(");
            System.exit(0);
        } 

        for (Dot dot1 : dotsList.subList(0, dotsList.size() - 1)) {
            for (Dot dot2 : dotsList.subList(dotsList.indexOf(dot1) + 1, dotsList.size())) {
                Line line;

                if (dot1.x == dot2.x) {
                    line = new Line("x", dot1.x);
                }
                else if (dot1.y == dot2.y) {
                    line = new Line("y", dot1.y);
                }
                else {
                    double k = (dot2.y - dot1.y) / (dot2.x - dot1.x);
                    double x = dot1.x * k * -1 + dot1.y;

                    k = (double) Math.round(k * 100) / 100;
                    x = (double) Math.round(x * 100) / 100;

                    line = new Line(k, x);
                }

                HashSet<Dot> dots = lines.get(line);
                if (dots == null) {
                    lines.put(line, new HashSet<Dot>(Arrays.asList(dot1, dot2)));
                }
                else {
                    dots.addAll(Arrays.asList(dot1, dot2));
                }
            }
        }

        lines.forEach((line, dots) -> {
            if (dots.size() > 2) {
                System.out.println("Прямая " + parseLine(line) + " пересекается с " + dots.size() + " точками");
            }
        });
    }
}
