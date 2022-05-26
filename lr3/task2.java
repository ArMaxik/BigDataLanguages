import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

import javafx.application.HostServices;

public class task2 {
    public static void main(String[] args) {
        houses();
        phones();
    }

    private static void houses() {
        ArrayList<task2_House> houses = new ArrayList<task2_House>();
        houses.add(new task2_House(
            1,
            12,
            56,
            3,
            4,
            "Lenina",
            "Type A",
            100
        ));
        houses.add(new task2_House(
            2,
            43,
            34,
            5,
            6,
            "Lesnya",
            "Type B",
            85
        ));
        houses.add(new task2_House(
            3,
            55,
            12,
            7,
            3,
            "Stroiteley",
            "Type C",
            120
        ));
        System.out.println(houses.get(0));
        System.out.println(houses.get(1));
        System.out.println(houses.get(2));

        System.out.println("Flats with 4 rooms:");
        findFlatByRooms(4, houses);
        System.out.println("Flats with 4 rooms and flor between 0 and 50:");
        findFlatByRoomsAndRange(4, 0, 50, houses);
        System.out.println("Flats with square more than 30:");
        findFlatBySq(30, houses);
    }

    private static void findFlatByRooms(int roomsNum, ArrayList<task2_House> houses) {
        for (task2_House h : houses) {
            if (h.get_Room_count() == roomsNum) {
                System.out.println(h);
            }
        }
    }

    private static void findFlatByRoomsAndRange(int roomsNum, int fs, int fe, ArrayList<task2_House> houses) {
        for (task2_House h : houses) {
            if (h.get_Room_count() == roomsNum && h.get_Floor() >= fs && h.get_Floor() < fs) {
                System.out.println(h);
            }
        }
    }

    private static void findFlatBySq(int minsq, ArrayList<task2_House> houses) {
        for (task2_House h : houses) {
            if (h.get_Square() > minsq) {
                System.out.println(h);
            }
        }
    }

    private static void phones() {
        ArrayList<task2_Phone> phones = new ArrayList<task2_Phone>();
        phones.add(new task2_Phone(
            1,
            "Smolko",
            "Igor",
            "Ogorevich",
            "Lenina 4",
            1234,
            45.5,
            67.7,
            123,
            431
        ));
        phones.add(new task2_Phone(
            2,
            "Usmanov",
            "Maxim",
            "Maximovich",
            "Lenina 43",
            982374,
            87.1,
            41.9,
            981,
            321
        ));
        phones.add(new task2_Phone(
            3,
            "Tarasov",
            "Victor",
            "Tarasenko",
            "Lenina 123",
            532,
            33.5,
            69.7,
            0,
            0
        ));
        System.out.println(phones.get(0));
        System.out.println(phones.get(1));
        System.out.println(phones.get(2));

        System.out.println("People with more than 2 intacalls:");
        findByIntra(2, phones);
        System.out.println("People with intercalls:");
        findByInter(phones);
        System.out.println("Sorted:");
        printSorted(phones);
    }

    private static void findByIntra(int num, ArrayList<task2_Phone> phones) {
        for (task2_Phone p : phones) {
            if (p.get_Intracity_calls() > num) {
                System.out.println(p);
            }
        }
    }

    private static void findByInter(ArrayList<task2_Phone> phones) {
        for (task2_Phone p : phones) {
            if (p.get_Intercity_calls() > 0) {
                System.out.println(p);
            }
        }
    }
    
    private static void printSorted(ArrayList<task2_Phone> phones) {
        // Arrays.sort(phones, Comparator.comparing(a -> a.get_Last_name()));
        Collections.sort(phones, new LastNameComparator());

        for (task2_Phone p : phones) {
            System.out.println(p);
        }
    }
}


class LastNameComparator implements Comparator<task2_Phone> {
    
    // override the compare() method
    public int compare(task2_Phone s1, task2_Phone s2)
    {
        return s1.get_Last_name().compareTo(s2.get_Last_name());
    }
}
