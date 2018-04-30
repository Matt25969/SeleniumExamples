package com.qa.seleniumexamples.BlackJack;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ParametisedBlackJackTest {

	@Parameters
	public static List<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { 0, 22, 0 }, { 22, 22, 0 }, { 12, 15, 15 }, { 21, 20, 21 },
				{ 14, 13, 14 }, { 25, 5, 5 }, { 20, 21, 21 }, { 22, 10, 10 } });
	}

	private int Input1;
	private int Input2;
	private int Expected;

	public ParametisedBlackJackTest(int input1, int input2, int expected) {
		Input1 = input1;
		Input2 = input2;
		Expected = expected;
	}

	@Test
	public void test() {

		BlackJack blackjack = new BlackJack();

		assertEquals(Expected, blackjack.play(Input1, Input2));
	}

}
