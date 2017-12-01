// Author: Rey Punao
package test;


import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.TennisBall;

public class TestTennisBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testTennisBallConstructor() {
		TennisBall ball = new TennisBall(80, 80);
		assertEquals(ball.getCenterX(), 80, 0.0);
	}
	
	@Test
	public void testTennisBallSetBallX() {
		TennisBall ball = new TennisBall(80, 80);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	@Test
	public void testTennisBallSetBallY() {
		TennisBall ball = new TennisBall(80, 80);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	@Test
	public void testTennisBallGetBallRadius() {
		TennisBall ball = new TennisBall(80, 80);
		assertEquals(ball.getRadius(), 20, 0.0);
	}
}
