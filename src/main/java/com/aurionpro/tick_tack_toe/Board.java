package com.aurionpro.tick_tack_toe;

import com.aurionpro.Exceptions.InvalidMoveException;

public class Board {
	private final int SIZE = 3;
	Cell[][] cells;

	public Board() {
		cells = new Cell[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j] = new Cell();
			}
		}
	}

	public void display() {
		System.out.println("Current Board:");
		for (int i = 0; i < SIZE; i++) {
			String row = "";
			for (int j = 0; j < SIZE; j++) {
				row += " " + cells[i][j] + " ";
				if (j < SIZE - 1) {
					row += "|";
				}
			}
			System.out.println(row);
			if (i < SIZE - 1) {
				System.out.println("---+---+---");
			}
		}
	}

	public boolean markCell(int row, int col, MarkType mark) throws InvalidMoveException {
		if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
			throw new InvalidMoveException("Invalid cell coordinates. Please choose values between 1 and 3.");
		}
		if (cells[row][col].getMark() != MarkType.EMPTY) {
			throw new InvalidMoveException("Cell is already marked. Choose another cell.");
		}
		cells[row][col].setMark(mark);
		return true;
	}

	// Optional: Add logic to check for winner, board full, etc.
	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cells[i][j].getMark() == MarkType.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean hasWinner(MarkType mark) {
		for (int i = 0; i < 3; i++) {
			// Check rows and columns
			if ((cells[i][0].getMark() == mark && cells[i][1].getMark() == mark && cells[i][2].getMark() == mark)
					|| (cells[0][i].getMark() == mark && cells[1][i].getMark() == mark
							&& cells[2][i].getMark() == mark)) {
				return true;
			}
		}

		// Check diagonals
		if ((cells[0][0].getMark() == mark && cells[1][1].getMark() == mark && cells[2][2].getMark() == mark)
				|| (cells[0][2].getMark() == mark && cells[1][1].getMark() == mark && cells[2][0].getMark() == mark)) {
			return true;
		}

		return false;
	}

}
