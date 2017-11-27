// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import game.BallFactory;
import game.GameBall;
import game.BallFactory.BallType;

public class TestBallFactory {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestBallFactoryNewGameBall() {
		 
		BallFactory factory = new BallFactory();
		GameBall ball = factory.newGameBall(BallType.BASKETBALL);
		assertTrue(ball instanceof GameBall);
	}
}