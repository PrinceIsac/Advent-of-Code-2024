package advent.of.code._4.advent.of.code._4;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootTest
class AdventOfCode2024ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void dayTwoTests() {
		//Input
		List<String> stringList = new ArrayList<>();
		stringList.add("7 6 4 2 1");
		stringList.add("1 2 7 8 9");
		stringList.add("9 7 6 2 1");
		stringList.add("1 3 2 4 5");
		stringList.add("8 6 4 4 1");
		stringList.add("1 3 6 7 9");

		//We expect the answer to be 2
		AtomicLong atomicLong = new AtomicLong(2);

		Assert.isTrue(Day2.solution1(stringList).get() == atomicLong.get(),"The expected value is 2");

		//Solution to the quiz
		AtomicLong atomicLong2 = new AtomicLong(369);
		Assert.isTrue(Day2.solution1(InputClass.dayTwoInput()).get() == atomicLong2.get(),"The expected value is 369");

	}

}
