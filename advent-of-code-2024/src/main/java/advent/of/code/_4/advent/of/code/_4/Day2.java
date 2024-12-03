package advent.of.code._4.advent.of.code._4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Day2 {
    public static AtomicLong solution1(List<String> input){

        AtomicLong unsafeReports = new AtomicLong();
        input.stream().map(row -> Arrays.stream(row.split(" ")).// Split each row into an array of strings
                mapToLong(Integer::parseInt) // Convert each string to a long
                .toArray()). // Collect into an array of longs
                forEach(array -> {
                    //Convert the long[] to list of Long since that is what is expected by our helper methods isDecreasing and isIncreasing
                    List<Long> longs = Arrays.stream(array).boxed() //boxed -> Returns a Stream consisting of the elements of this stream, each boxed to a Long.
                            .toList();
                    unsafeReports.addAndGet(isDecreasing(longs));
                    unsafeReports.addAndGet(isIncreasing(longs));
        });
        return unsafeReports;
    }

    public static int  isDecreasing(List<Long> list){
        boolean isDecreasing = IntStream.range(0, list.size() -1) //Generate a stream of indices from 0 to list.size() - 2
                // check if the element at position i is strictly less than the element at position i + 1
                //And the difference between the elements is at most 3
                .allMatch(i -> list.get(i) > list.get(i + 1) && (Math.abs(list.get(i + 1) - list.get(i)) <= 3));

        return isDecreasing ? 1 : 0;
    }

    public static int isIncreasing(List<Long> list){
        boolean isIncreasing =  IntStream.range(0, list.size() -1) //Generate a stream of indices from 0 to list.size() - 2
                // check if the element at position i is strictly less than the element at position i + 1 and their difference <= 3
                .allMatch(i -> list.get(i) < list.get(i + 1) && (Math.abs(list.get(i) - list.get(i + 1)) <= 3)  );
        return isIncreasing ? 1 : 0;
    }



}
