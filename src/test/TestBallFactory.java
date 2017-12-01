// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import game.ball.Ball;
import game.ball.BallFactory;
import game.ball.BasketBall;
import game.ball.BallFactory.BallType;

public class TestBallFactory {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void testBallFactoryNewGameBall() {
		 
		BallFactory factory = new BallFactory();
		Ball ball = factory.newGameBall(BallType.BASKETBALL);
		assertTrue(ball instanceof BasketBall);
	}
}