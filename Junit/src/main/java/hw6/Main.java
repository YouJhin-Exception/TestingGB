package hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);

        List<Integer> list2 = new ArrayList<>();
        list2.add(15);
        list2.add(25);
        list2.add(35);

        ListAverageComparator listAverageComparator = new ListAverageComparator(list1, list2);
        listAverageComparator.compareAverages();

    }
}
