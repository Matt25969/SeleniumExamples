package com.qa.seleniumexamples.BlackJack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BlackJackTest {
	BlackJack blackjack;

	@Before
	public void setup() {
		blackjack = new BlackJack();
	}

	@Test
	public void playTest() {

		assertEquals(20, blackjack.play(16, 20));

	}

	@Test
	public void playTest1() {

		assertEquals(10, blackjack.play(10, 22));
		assertEquals(18, blackjack.play(18, 22));
		assertEquals(11, blackjack.play(11, 22));
		assertEquals(12, blackjack.play(12, 22));
		assertEquals(13, blackjack.play(13, 22));
		assertEquals(18, blackjack.play(14, 18));

	}

	@Test
	public void isThisATest() {

		blackjack.play(10, 21);

	}

}
