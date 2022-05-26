import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class L6_4 {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.dir") + "\\src\\segments.txt";
        
        ArrayList<Segment> segments = new ArrayList<Segment>();
        TreeMap<Double, Segment[]> map = new TreeMap<Double, Segment[]>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            for (String lineStr; (lineStr = br.readLine()) != null;) {
                String[] dots = lineStr.split(" - ");
                String[] dot1S = dots[0].split(" ");
                String[] dot2S = dots[1].split(" ");

                Dot dot1 = new Dot(Integer.parseInt(dot1S[0]), Integer.parseInt(dot1S[1]));
                Dot dot2 = new Dot(Integer.parseInt(dot2S[0]), Integer.parseInt(dot2S[1]));

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

                segments.add(new Segment(dot1, dot2, line));
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так :(");
            System.exit(0);
        }
        
        // Перебираем все пары отрезков
        for (Segment seg1 : segments.subList(0, segments.size() - 1)) {
            for (Segment seg2 : segments.subList(segments.indexOf(seg1) + 1, segments.size())) {
                System.out.println(seg1.toString() + "\n" + seg2.toString());
                // Проверяем, что коэффициенты k не равны и прямые не параллельны одной и той же оси
                if (seg1.line.k != seg2.line.k || seg1.line.axis != seg2.line.axis) {
                    Segment[] pair = {seg1, seg2};

                    if (seg1.line.axis == null && seg2.line.axis == null) {         // Если прямые не параллельны OX и OY
                        double absc = (seg1.line.b - seg2.line.b) / (seg2.line.k - seg1.line.k);

                        Boolean inSeg1 = seg1.contains(absc);
                        Boolean inSeg2 = seg2.contains(absc);

                        if (inSeg1 && inSeg2) {
                            map.put(absc, pair);
                            System.out.println("Пересекаются на абсциссе " + absc);
                        }
                    }
                    else if (seg1.line.axis != null && seg2.line.axis == null) {    // Если прямая seg1 параллельна одной из осей
                        if (seg1.line.axis == "x") {
                            double absc = seg1.line.axisValue;

                            if (seg2.contains(absc)) {
                                map.put(absc, pair);
                                System.out.println("Пересекаются на абсциссе " + absc);
                            }
                        }
                        else if (seg1.line.axis == "y") {
                            double absc = (seg1.line.axisValue - seg2.line.b) / seg2.line.k;

                            if (seg2.contains(absc)) {
                                map.put(absc, pair);
                                System.out.println("Пересекаются на абсциссе " + absc);
                            }
                        }
                    }
                    else if (seg1.line.axis == null && seg2.line.axis != null) {    // Если прямая seg2 параллельна одной из осей
                        if (seg2.line.axis == "x") {
                            double absc = seg2.line.axisValue;

                            if (seg1.contains(absc)) {
                                map.put(absc, pair);
                                System.out.println("Пересекаются на абсциссе " + absc);
                            }
                        }
                        else if (seg2.line.axis == "y") {
                            double absc = (seg2.line.axisValue - seg1.line.b) / seg1.line.k;

                            if (seg1.contains(absc)) {
                                map.put(absc, pair);
                                System.out.println("Пересекаются на абсциссе " + absc);
                            }
                        }
                    }
                    else {  // Если прямые параллельны различным осям
                        if (seg1.line.axis == "x") {
                            map.put(seg1.line.axisValue, pair);
                            System.out.println("Пересекаются на абсциссе " + seg1.line.axisValue);
                        }
                        else if (seg2.line.axis == "x") {
                            map.put(seg2.line.axisValue, pair);
                            System.out.println("Пересекаются на абсциссе " + seg2.line.axisValue);
                        }
                    }
                }
                else {
                    System.out.println("Параллельны друг другу");
                }

                System.out.println();
            }
        }

        System.out.println("Минимальная абсцисса: " + map.firstKey());
    }
}