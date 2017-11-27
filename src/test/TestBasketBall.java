// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import game.ball.BasketBall;
import javafx.scene.paint.Color;

public class TestBasketBall {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void TestBasketBallConstructor() {
		BasketBall ball = new BasketBall(400, 400);
		assertEquals(ball.getCenterX(), 400, 0.0);
	}
	
	@Test
	public void TestBasketBallSetBallX() {
		BasketBall ball = new BasketBall(400, 400);
		ball.setCenterX(200.0);
		assertEquals(ball.getCenterX(), 200, 0.0);
	}
	
	@Test
	public void TestBasketBallSetBallY() {
		BasketBall ball = new BasketBall(400, 400);
		ball.setCenterY(200.0);
		assertEquals(ball.getCenterY(), 200, 0.0);
	}
	
	@Test
	public void TestBasketBallGetBallRadius() {
		BasketBall ball = new BasketBall(400, 400);
		assertEquals(ball.getRadius(), 20, 0.0);
	}
}
