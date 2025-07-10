package com.aurionpro.basics.PigGame;

import java.util.*;

public class PigGameApp {

	Scanner scanner = new Scanner(System.in);

	private int totalScore = 0;
	private int turn = 1;

	public void start() {
		System.out.println("Let's Play PIG");

		while (turn < 5 && totalScore < 20) {
			playTurn();

		}
		if (totalScore < 20) {
			System.out.println("You lose. Total score: " + totalScore);
		}
		turn++;
	}

	private void playTurn() {
		int turnScore = 0;
		System.out.println("Turn " + turn);

		while (true) {
			System.out.print("Roll or Hold? (r/h): ");
			String action = scanner.next().toLowerCase();

			if (action.equals("r")) {
				turnScore = playRoll(turnScore);
			}

			if (action.equals("h")) {
				totalScore += turnScore;																										
				playHold(turnScore);
				return;
			}
		}
	}

	public int playRoll(int turnScore) {
		int roll = rollDice();
		System.out.println("Die: " + roll);

		if (roll == 1) {
			System.out.println("Turn over. No score");
			turn++;
			return 0;
		}

		return (turnScore + roll);
	}

	public void playHold(int turnScore) {
		
		System.out.println("Score for the turn: " + turnScore + ", Total score: " + totalScore);

		if (totalScore >= 20) {
			System.out.println("You won!! Finished in " + turn + " turn");
			System.exit(0);
		}
		return;
	}

	private int rollDice() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}
}
