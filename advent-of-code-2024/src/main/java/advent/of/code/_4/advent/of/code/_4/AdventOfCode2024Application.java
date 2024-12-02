package advent.of.code._4.advent.of.code._4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdventOfCode2024Application {

	public static void main(String[] args) {
		List<Integer> list1 =  Arrays.asList(1,2,3,4,5); //4 + 4 + 5
		List<Integer> list2 =  Arrays.asList(2,2,0,4,5);
		SpringApplication.run(AdventOfCode2024Application.class, args);
		//Solution One
		System.out.println(Day1.solution1(InputClass.dayOneInput().getFirst(), InputClass.dayOneInput().getLast()));

		//Solution Two
		System.out.println(Day1.solution2(InputClass.dayOneInput().getFirst(), InputClass.dayOneInput().getLast()));
	}}