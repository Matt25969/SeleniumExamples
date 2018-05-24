package com.qa.seleniumexamples.BlackJack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlackJackTest {

	@Test
	public void playTest() {

		BlackJack blackjack = new BlackJack();

		assertEquals(11, blackjack.play(11, 22));

	}

	@Test
	public void playTest1() {

		BlackJack blackjack = new BlackJack();

		assertEquals(10, blackjack.play(10, 22));
		assertEquals(18, blackjack.play(18, 22));
		assertEquals(11, blackjack.play(11, 22));
		assertEquals(12, blackjack.play(12, 22));
		assertEquals(13, blackjack.play(13, 22));
		assertEquals(14, blackjack.play(14, 22));

	}

	@Test
	public void isThisATest() {
		BlackJack blackjack = new BlackJack();

		blackjack.play(10, 21);

	}

}
