package advent.of.code._4.advent.of.code._4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdventOfCode2024Application {

	public static void main(String[] args) {
		SpringApplication.run(AdventOfCode2024Application.class, args);
		//Day One
		System.out.println(Day1.calculateDistanceBetweenLists(InputClass.dayOneInput().getFirst(), InputClass.dayOneInput().getLast()));
	}}