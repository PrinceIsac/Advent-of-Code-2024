package advent.of.code._4.advent.of.code._4;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static int calculateDistanceBetweenLists(List<Integer> list1, List<Integer> list2) {
        int sum = 0;
        //Sort the two lists
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        //Add the total distance
        for (int i = 0; i < list1.size(); i++) {
            sum += (Math.abs(list1.get(i) - list2.get(i)));
        }
        return sum;
    }
}
