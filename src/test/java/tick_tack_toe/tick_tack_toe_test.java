package tick_tack_toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aurionpro.Exceptions.InvalidMoveException;
import com.aurionpro.tick_tack_toe.Board;
import com.aurionpro.tick_tack_toe.MarkType;

class tick_tack_toe_test {

	Board board;

	@BeforeEach
	void init() {
		board = new Board();
	}

	

	@Test
	void markCell() {
		try{
			board.markCell(2,2,MarkType.O);
			board.markCell(2,2,MarkType.O);
			}catch(InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
	}
	
	@AfterAll
	static void Display() {
		System.out.println("Testing Complete");
	}

}
