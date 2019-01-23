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
		return Arrays.asList(new Integer[][] { { 0, 22, 0 }, { 0, 22, 22 }, { 15, 15, 12 }, { 21, 20, 21 },
				{ 14, 13, 14 }, { 6, 6, 25 }, { 21, 21, 20 }, { 10, 10, 22 } });
	}
	
	private int Expected;
	private int Input1;
	private int Input2;
	

	public ParametisedBlackJackTest(int expected, int input2, int input1) {
		
		Expected = expected;
		Input1 = input1;
		Input2 = input2;
		
	}

	@Test
	public void test() {

		BlackJack blackjack = new BlackJack();

		assertEquals(Expected, blackjack.play(Input1, Input2));
	}

}
