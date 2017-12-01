// Author: Mark Toujiline
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import layout.PlayerName;

public class TestPlayerName {
	@Test
	public void testPlayerNameConstructor() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		assertEquals(playerName.getName(), "name");
	}
	@Test
	public void testPlayerNameName() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		playerName.setName("newName");
		assertEquals(playerName.getName(), "newName");
	}
	@Test
	public void testPlayerNameRank() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		playerName.setRank(3);
		assertEquals(playerName.getRank(), 3);
	}
	@Test
	public void testPlayerNameScore() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		playerName.setScore(2500);
		assertEquals(playerName.getScore(), 2500);
	}
	@Test
	public void testPlayerNameWins() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		playerName.setWins(50);
		assertEquals(playerName.getWin(), 50);
	}
	@Test
	public void testPlayerNameLosses() {
		PlayerName playerName = new PlayerName(1, "name", 100, 2, 3);
		playerName.setLoss(50);
		assertEquals(playerName.getLoss(), 50);
	}
}