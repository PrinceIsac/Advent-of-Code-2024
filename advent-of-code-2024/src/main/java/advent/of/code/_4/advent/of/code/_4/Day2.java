package advent.of.code._4.advent.of.code._4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Day2 {

    public static AtomicLong solution1(List<String> input) {
        AtomicLong unsafeReports = new AtomicLong();
        input.stream().map(row -> Arrays.stream(row.split(" ")) // Split each row into an array of strings
                        .mapToLong(Integer::parseInt) // Convert each string to a long
                        .toArray()) // Collect into an array of longs
                .forEach(array -> {
                    // Convert the long[] to list of Long since that is what is expected by our helper methods isDecreasing and isIncreasing
                    List<Long> longs = Arrays.stream(array).boxed() //boxed -> Returns a Stream consisting of the elements of this stream, each boxed to a Long.
                            .toList();
                    unsafeReports.addAndGet(isDecreasing(longs));
                    unsafeReports.addAndGet(isIncreasing(longs));
                });
        return unsafeReports;
    }

    public static AtomicLong solution2(List<String> input) {
        ArrayList<List<Long>> unsafe = new ArrayList<>();
        AtomicLong unsafeReports = new AtomicLong();
        input.stream().map(row -> Arrays.stream(row.split(" ")) // Split each row into an array of strings
                        .mapToLong(Integer::parseInt) // Convert each string to a long
                        .toArray()) // Collect into an array of longs
                .forEach(array -> {
                    // Convert the long[] to list of Long since that is what is expected by our helper methods isDecreasing and isIncreasing
                    List<Long> longs = Arrays.stream(array).boxed() //boxed -> Returns a Stream consisting of the elements of this stream, each boxed to a Long.
                            .toList();
                    unsafeReports.addAndGet(isDecreasing(longs));
                    unsafeReports.addAndGet(isIncreasing(longs));
                    // Check if the report is not already safe, and if removing one level makes it safe
                    if (isDecreasing(longs) == 0 && isIncreasing(longs) == 0 ) {
                        unsafeReports.addAndGet(verifyArrayIncrementAfterLevelDrop(longs));
                    }
                    if(isIncreasing(longs) == 0 && isDecreasing(longs) == 0 ) {
                        unsafeReports.addAndGet(verifyArrayDecrementAfterLevelDrop(longs));
                    }
                    if (isIncreasing(longs) == 0 && isDecreasing(longs) == 0 && verifyArrayDecrementAfterLevelDrop(longs) == 0 && verifyArrayIncrementAfterLevelDrop(longs) == 0){
                        unsafeReports.addAndGet(isDecreasingAfterRemovingLastElement(longs));
                    }
                    if (isIncreasing(longs) == 0 && isDecreasing(longs) == 0 && verifyArrayDecrementAfterLevelDrop(longs) == 0 && verifyArrayIncrementAfterLevelDrop(longs) == 0){
                        unsafeReports.addAndGet(isIncreasingAfterRemovingLastElement(longs));
                    }

                });
        return unsafeReports;
    }

    // Verifies if removing one level from the array makes it strictly increasing
    public static int verifyArrayIncrementAfterLevelDrop(List<Long> input) {
        for (int i = 0; i < input.size() - 1; i++) { //Loop until second last value
            // Make a temporary copy of the input list
            List<Long> tempList = new ArrayList<>(input);

            // Hold the value at the index to be removed
            long valueHolder = tempList.get(i);

            // Remove the element at the current index
            tempList.remove(i);

            // Check if the remaining list is strictly increasing
            if (isIncreasing(tempList) == 1) {
                return 1; // If the sequence becomes increasing after removal, it's safe
            }
            // If not valid, add the removed value back to the list at the correct index
            tempList.add(i, valueHolder); // Adds the value back at the original index
        }

        return 0; // No successful removal made it increasing
    }

    // Verifies if removing one level from the array makes it strictly decreasing
    public static int verifyArrayDecrementAfterLevelDrop(List<Long> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            List<Long> tempList = new ArrayList<>(input);
            tempList.remove(i);
            // Hold the value at the index to be removed
            long valueHolder = tempList.get(i);

            if (isDecreasing(tempList) == 1) {
                return 1; // If the sequence becomes decreasing after removal, it's safe
            }
            // If not valid, add the removed value back to the list at the correct index
            tempList.add(i, valueHolder); // Adds the value back at the original index
        }
        return 0; // No successful removal made it decreasing
    }

    // Checks if the list is strictly decreasing and the differences are within the allowed range
    public static int isDecreasing(List<Long> list) {
        return IntStream.range(0, list.size() - 1)
                .allMatch(i -> list.get(i) > list.get(i + 1) && Math.abs(list.get(i + 1) - list.get(i)) <= 3) ? 1 : 0;
    }

    // Checks if the list is strictly increasing and the differences are within the allowed range
    public static int isIncreasing(List<Long> list) {
        return IntStream.range(0, list.size() - 1)
                .allMatch(i -> list.get(i) < list.get(i + 1) && Math.abs(list.get(i) - list.get(i + 1)) <= 3) ? 1 : 0;
    }

    public static int isIncreasingAfterRemovingLastElement(List<Long> list){
        //Create a mutable arraylist to be able to remove elements
        ArrayList<Long> tempList = new ArrayList<>(list);
        //Remove the last element
        tempList.removeLast();
        return IntStream.range(0, tempList.size() - 1)
                .allMatch(i -> tempList.get(i) < tempList.get(i + 1) && Math.abs(tempList.get(i) - tempList.get(i + 1)) <= 3) ? 1 : 0;
    }

    public static int isDecreasingAfterRemovingLastElement(List<Long> list){
        ArrayList<Long> tempList = new ArrayList<>(list);
        //Remove the last element
        tempList.removeLast();
        return IntStream.range(0, tempList.size() - 1)
                .allMatch(i -> tempList.get(i) > tempList.get(i + 1) && Math.abs(tempList.get(i + 1) - tempList.get(i)) <= 3) ? 1 : 0;
    }
}

