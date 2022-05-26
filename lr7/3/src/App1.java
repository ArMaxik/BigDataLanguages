import java.util.LinkedList;

public class App1 {
    public static void main(String[] args) throws Exception {
        String sentence = "На клетчатом листе бумаги закрашена часть клеток. Выделить все различные фигуры, которые образовались при этом. Фигурой считается набор закрашенных клеток, достижимых друг из друга при движении в четырёх направлениях. Две фигуры являются различными, если их нельзя совместить поворотом на угол, кратный 90 градусам, и параллельным переносом. Используйте класс HashSet.";

        LinkedList<String> list = new LinkedList<String>();

        for (String word : sentence.split(" ")) {
            list.add(word);
        }

        list.add(list.removeFirst());

        System.out.println(String.join(" ", list));
    }
}
