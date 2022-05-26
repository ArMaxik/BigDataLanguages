import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App1 {
    public static void main(String[] args) throws Exception {
        String text = "На клетчатом листе бумаги закрашена часть клеток. Выделить все различные фигуры, которые образовались при этом. Фигурой считается набор закрашенных клеток, достижимых друг из друга при движении в четырёх направлениях. Две фигуры являются различными, если их нельзя совместить поворотом на угол, кратный 90 градусам, и параллельным переносом. Используйте класс HashSet.";
        Matcher m = Pattern.compile("[^А-я]*[А-я]+[^А-я]*").matcher(text);

        ArrayList<String> list = new ArrayList<String>();

        while (m.find()) {
            System.out.println(m.group());
            String word = m.group().replaceAll("[ .,?!;:]", "");;
            list.add(word);
        }

        Collections.sort(list);
        System.out.println(list);
    }
}
