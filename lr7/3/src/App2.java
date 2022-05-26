public class App2 {
    public static void main(String[] args) {
        String text = "На плоскости задано N отрезков. Найти точку пересечения двх отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap. ";
        String codedText = "";

        for (int i = 0; i < text.length(); i += 3) {
            codedText += text.charAt(i);
        }

        for (int i = 1; i < text.length(); i += 3) {
            codedText += text.charAt(i);
        }

        for (int i = 2; i < text.length(); i += 3) {
            codedText += text.charAt(i);
        }

        System.out.println("Начальный текст: " + text);
        System.out.println("Закодированный текст: " + codedText);
    }
}
