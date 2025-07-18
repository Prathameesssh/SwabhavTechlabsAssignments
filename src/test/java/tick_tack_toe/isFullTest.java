package tick_tack_toe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aurionpro.tick_tack_toe.Board;

class isFullTest {
	
	Board board;

	@BeforeEach
	void init() {
		board = new Board();
	}

	@Test
	void isFull() {

		assertEquals(false, board.isFull());

	}

}
