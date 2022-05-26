package task3;

import java.util.*;
import java.text.*;

public class task3 {
    
    public static void main(String[] args) {
        Rose rose = new Rose("Red");
        System.out.println(rose);
        rose.bloom();
        System.out.println(rose);
        rose.wither();
        System.out.println(rose);

        System.out.println();

        Tree tree = new Tree();
        System.out.println(tree);
        tree.fall();
        System.out.println(tree);
        tree.snow();
        System.out.println(tree);
        tree.yellow();
        System.out.println(tree);
        tree.bloom();
        System.out.println(tree);
    }
}
