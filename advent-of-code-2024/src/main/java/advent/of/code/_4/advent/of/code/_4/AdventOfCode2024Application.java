package advent.of.code._4.advent.of.code._4;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdventOfCode2024Application {

	public static void main(String[] args) {
		List<String> list1 =  Arrays.asList("1 2 3 4 8","10 20 30 1 4 5");
		List<Integer> list2 =  Arrays.asList(2,2,0,4,5);
		List<String> stringList = new ArrayList<>();
		stringList.add("7 6 4 2 1");
		stringList.add("1 2 7 8 9");
		stringList.add("9 7 6 2 1");
		stringList.add("1 3 2 4 5");
		stringList.add("8 6 4 4 1");
		stringList.add("1 3 6 7 9");
//		SpringApplication.run(AdventOfCode2024Application.class, args);
//		//Solution One
//		System.out.println(Day1.solution1(InputClass.dayOneInput().getFirst(), InputClass.dayOneInput().getLast()));
//
//		//Solution Two
//		System.out.println(Day1.solution2(InputClass.dayOneInput().getFirst(), InputClass.dayOneInput().getLast()));

//		System.out.println(Day2.solution1(InputClass.dayTwoInput()));

		System.out.println(Day2.solution2(InputClass.dayTwoInput()));

	}}