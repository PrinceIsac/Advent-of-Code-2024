package advent.of.code._4.advent.of.code._4;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Day1 {
    public static int solution1(List<Integer> list1, List<Integer> list2) {
        long startTime = System.nanoTime();
        int sum = 0;
        //Sort the two lists
        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
        //Add the total distance
        for (int i = 0; i < list1.size(); i++) {
            sum += (Math.abs(list1.get(i) - list2.get(i)));
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");
        return sum;
    }

    public static long solution2(List<Integer> list1, List<Integer> list2) {
        long startTime = System.nanoTime();
        //We traver the array obtaining the frequency of a number from list 1 in list 2
        //The number in list 1 is the key and the frequency is the value
        //Frequency map of list 2
        Map<Integer, Long> frequencyMap = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //Calculate weighted sum
        long result = list1.stream().mapToLong(number -> frequencyMap.getOrDefault(number, 0L) * number).sum();
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");
        return result;
    }
}
