package com.aurionpro.tick_tack_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.Exceptions.InvalidMoveException;

public class Game {
	private final Board board;
	private MarkType currentMark;
	private final Scanner scanner;

	public Game() {
		board = new Board();
		currentMark = MarkType.X; // X always starts
		scanner = new Scanner(System.in);
	}

	public void start() {
		boolean gameOver = false;
		while (!gameOver) {
			board.display();
			System.out.println("Player " + currentMark + ", enter your move (row and column separated by space 1-3): ");
			try {
				int row = scanner.nextInt();
				int col = scanner.nextInt();
				board.markCell(row-1, col-1, currentMark);
				// Optionally, after each move, check for win condition or draw.
				 if (board.hasWinner(currentMark)) {
		                System.out.println("\nPlayer " + currentMark + " wins!");
		                break;
		            }
				
				  if (board.isFull()) {
		                System.out.println("\nIt's a draw!");
		                break;
		            }
				// For now, we simply alternate turns.
				currentMark = (currentMark == MarkType.X) ? MarkType.O : MarkType.X;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid input. Please enter two integers separated by a space.");
				scanner.nextLine(); // clear the invalid input
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			} catch (Exception e) {
				System.out.println("Unexpected error: " + e.getMessage());
			}

		}
	}


}
