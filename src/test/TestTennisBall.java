// Author: Ryan Lawrence
package test;


import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.TennisBall;

public class TestTennisBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void TestTennisBallConstructor() {
		TennisBall ball = new TennisBall(80, 80);
		assertEquals(ball.getCenterX(), 80, 0.0);
	}
	
	@Test
	public void TestTennisBallSetBallX() {
		TennisBall ball = new TennisBall(80, 80);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	@Test
	public void TestTennisBallSetBallY() {
		TennisBall ball = new TennisBall(80, 80);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	@Test
	public void TestTennisBallGetBallRadius() {
		TennisBall ball = new TennisBall(80, 80);
		assertEquals(ball.getRadius(), 20, 0.0);
	}
}
