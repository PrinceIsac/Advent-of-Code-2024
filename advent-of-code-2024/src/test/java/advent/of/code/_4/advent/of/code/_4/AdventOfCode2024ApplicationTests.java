package advent.of.code._4.advent.of.code._4;

import org.junit.jupiter.api.Assertions;
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

		//Solution 2 Tests
		//We expect the answer to be 4
		AtomicLong atomicLong3 = new AtomicLong(4);
		Assertions.assertEquals(atomicLong3.get(), Day2.solution2(stringList).get(),"The expected value is 4");

		//Solution 2 Actual Data Result
		AtomicLong atomicLong4 = new AtomicLong(428);
		Assertions.assertEquals(atomicLong4.get(), Day2.solution2(InputClass.dayTwoInput()).get(),"The expected value is 428");

	}

	@Test
	public void dayThreeTests() {
		String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

		Assertions.assertEquals(161, Day3.solutionOne(input),"The expected sum is 161");

		//Test with test data
		Assertions.assertEquals(157621318, Day3.solutionOne(InputClass.dayThreeInput()),"The expected sum is 157621318");

	}

}
