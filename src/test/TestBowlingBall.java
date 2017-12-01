// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.BowlingBall;

public class TestBowlingBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testBowlingBallConstructor() {
		BowlingBall ball = new BowlingBall(80, 80);
		assertEquals(ball.getCenterX(), 80, 0.0);
	}

	@Test
	public void testBowlingBallSetBallX() {
		BowlingBall ball = new BowlingBall(80, 80);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	@Test
	public void testBowlingBallSetBallY() {
		BowlingBall ball = new BowlingBall(80, 80);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	@Test
	public void testBowlingBallGetBallRadius() {
		BowlingBall ball = new BowlingBall(80, 80);
		assertEquals(ball.getRadius(), 20, 0.0);
	}
}
