import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App2 {
    public static void main(String[] args) {
        String text = "А Вы Бы Не Хотели";
        Matcher m = Pattern.compile("[^А-я]*[А-Я][А-я]*[^А-я]*").matcher(text);

        int a = 0;
        while (m.find()) {
            a++;
        }
        System.out.println(a);
    }
}
