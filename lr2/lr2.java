import java.util.*;
import java.text.*;

public class lr2 {

    public static void main(String[] args) {
        print_info();
        task1();
        task2();
    }

    private static void print_info() {
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        String current_date = dateFormat.format(cal.getTime());
        System.out.println("=======================================");
        System.out.println("Developer: Eliseev Vyachelav");
        System.out.println("Created: 11.03.2022 17:47");
        System.out.println("Approved: " + current_date);
        System.out.println("=======================================");
    }

    private static void task1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();

        String asc = "";
        String diff = "";
        
        Vector<String> arr = new Vector<String>();
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("Enter %d word: ", i+1));
            String word = sc.nextLine();
            
            if (word.length() == 0) {
                System.out.println("ERROR, empty word!");
                i -= 1;
                continue;
            }

            if (is_asc(word) && asc.length() == 0) {
                asc = word;
            }
            if (is_diff(word) && diff.length() == 0) {
                diff = word;
            }
            arr.add(word);
        }
        System.out.println("All chars are ascending:");
        System.out.println(asc);
        System.out.println("All chars are different:");
        System.out.println(diff);
    }

    private static Boolean is_asc(String word) {
        for (int i = 1; i < word.length(); i++){
            if (word.charAt(i) <= word.charAt(i - 1)) {
                return false;
            }        
        }
        return true;
    }

    private static Boolean is_diff(String word) {
        HashSet<Character> h = new HashSet<Character>();
        for (int i = 0; i < word.length(); i++){
            h.add(word.charAt(i));
        }
        if (h.size() == word.length()) {
            return true;
        }
        return false;
    }

    private static void task2() {
        System.out.println("Enter n:");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println(String.format("Enter matrix %dx%d:", n, n));
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (sc.hasNextInt()) {
                    matrix[i][j] = sc.nextInt();
                } else {
                    System.out.println("Wrong number");
                    break;
                }
            }
        }
        System.out.println(String.format("Norm of matrix: %d", norm(matrix, n)));
        System.out.println("Rotated matrix by 90");
        rotate90(matrix, n);
        printMatrix(matrix);
        System.out.println("Rotated matrix by 180");
        rotate90(matrix, n);
        printMatrix(matrix);
        System.out.println("Rotated matrix by 270");
        rotate90(matrix, n);
        printMatrix(matrix);
    }

    private static Integer norm(int[][] matrix, int n) {
        int norm = 0;
        for (int i=0; i < n; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += matrix[i][j];
            }
            if (sum > norm) {
                norm = sum;
            }
        }
        return norm;
    }

    private static void rotate90(int[][] matrix, int n) {
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // Column reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }

    private static void printMatrix(int matrix[][])
    {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }
    }
}