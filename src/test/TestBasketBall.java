// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.BasketBall;

public class TestBasketBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testBasketBallConstructor() {
		BasketBall ball = new BasketBall(400, 400);
		assertEquals(ball.getCenterX(), 400, 0.0);
	}
	
	@Test
	public void testBasketBallSetBallX() {
		BasketBall ball = new BasketBall(400, 400);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	
	@Test
	public void testBasketBallSetBallY() {
		BasketBall ball = new BasketBall(400, 400);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	
	@Test
	public void testBasketBallGetBallRadius() {
		BasketBall ball = new BasketBall(400, 400);
		assertEquals(ball.getRadius(), 30, 0.0);
	}
}
