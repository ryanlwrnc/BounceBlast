// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import game.ball.Ball;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TestBallLayout {
	
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void TestBallLayoutConstructor() {
		Ball ball = new Ball(10.0, 10.0, 10.0, Color.BLACK);
		assertEquals(ball.getCenterX(), 10.0, 0.0);
	}
	@Test
	public void TestBallLayoutGetBallColor() {
		Ball ball = new Ball(10.0, 10.0, 10.0, Color.BLACK);
		assertEquals(ball.getFill(), Color.BLACK);
	}
	@Test
	public void TestBallLayoutRadius() {
		Ball ball = new Ball(10.0, 10.0, 10.0, Color.BLACK);
		ball.setRadius((float)47);
		assertEquals(ball.getRadius(), (float)47, 0.0);
	}
}