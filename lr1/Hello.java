import java.util.*;
import java.text.*;

public class Hello {
    public static void main(String[] args) {
        Hello.var1();
        Hello.var2();
    }

    private static void var1() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        String current_date = dateFormat.format(cal.getTime());
        System.out.println("=======================================");
        System.out.println("Developer: Eliseev Vyachelav");
        System.out.println("Created: 04.03.2022 17:47");
        System.out.println("Approved: " + current_date);
        System.out.println("=======================================");
        
        Scanner sc = new Scanner(System.in);  
        System.out.println("Whats is your name?");
        String name = sc.nextLine();
        do
        {
            System.out.println(String.format("Hello, %s!", name));
            System.out.println("Whats is your name? If you want exit, enter 'exit'. If your name is Exit, i'm sorry.");
            name = sc.nextLine();
        } while (!name.equals("exit"));
    }

    private static void var2() {
        System.out.print("All 3 digit numbers with unique digits: ");
        for (int num = 100; num <=1000; num++) {
            int d1 = num / 100;
            int d2 = (num % 100) / 10;
            int d3 = num % 10;
            if (d1 != d2 && d2 != d3 && d3 != d1) {
                System.out.print(String.format("%d ", num));
            }
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);  
        Vector<Integer> arr = new Vector<Integer>();
        
        System.out.print("Enter number of numbers: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println(String.format("Enter %d numbers:", n));
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                arr.add(sc.nextInt());
            } else {
                System.out.println("Wrong number");
                break;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(Hello.GCD_LCM(arr.get(i), arr.get(j)));
            }
        }
    }

    private static String GCD_LCM(int a, int b){
        int gcd = Hello.GCD(a, b);
        int lcd = (a / gcd) * b;

        return String.format("a: %-6d b: %-6d GCD: %-6d LCM: %-6d", a, b, gcd, lcd);
    }

    // Least common multiple
    private static int LCM(int a, int b) {
        return (a / Hello.GCD(a, b)) * b;
    }

    // Greatest common divisor
    private static int GCD(int a, int b) {
        if (a == 0)
            return b;
        return Hello.GCD(b % a, a);
    }
}
