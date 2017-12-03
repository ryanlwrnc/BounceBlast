// Author: Mark Toujiline
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.SoccerBall;

public class TestSoccerBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testSoccerBallConstructor() {
		SoccerBall ball = new SoccerBall(80, 80);
		assertEquals(ball.getCenterX(), 80, 0.0);
	}
	@Test
	public void testSoccerBallSetBallX() {
		SoccerBall ball = new SoccerBall(80, 80);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	@Test
	public void testSoccerBallSetBallY() {
		SoccerBall ball = new SoccerBall(80, 80);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	@Test
	public void testSoccerBallGetBallRadius() {
		SoccerBall ball = new SoccerBall(80, 80);
		assertEquals(ball.getRadius(), 27, 0.0);
	}
}
