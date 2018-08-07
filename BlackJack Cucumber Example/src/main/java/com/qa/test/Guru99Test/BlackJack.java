package com.qa.test.Guru99Test;

public class BlackJack {

	public int play(int player1, int player2) {

		if (player1 > 21 && player2 > 21) {

			return 0;

		} else if (player1 > 21) {

			return player2;

		} else if (player2 > 21) {

			return player1;

		} else {

			return Math.max(player1, player2);

		}
	}

}
