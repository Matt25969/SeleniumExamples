package com.qa.seleniumexamples.BlackJack;

public class RunnerClass {

	public static void main(String[] args) {
		BlackJack blackjack = new BlackJack();

		System.out.println(blackjack.play(10, 22));

	}
}
