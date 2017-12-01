// Author: Rey Punao
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import game.GameBoard;

public class TestGameBoard {
	@Test
	public void testGameBoardWidth() {
		GameBoard board = new GameBoard(1, 1, 2, 2);
		assertEquals(board.getWidth(), (double)2, 0.0);
	}
	@Test
	public void testGameBoardHeight() {
		GameBoard board = new GameBoard(1, 1, 2, 2);
		assertEquals(board.getHeight(), (double)2, 0.0);
	}
	@Test
	public void testGameBoardX() {
		GameBoard board = new GameBoard(1, 1, 2, 2);
		assertEquals(board.getX(), (double)1, 0.0);
	}
	@Test
	public void testGameBoardY() {
		GameBoard board = new GameBoard(1, 1, 2, 2);
		assertEquals(board.getY(), (double)1, 0.0);
	}
}
