// Author: Ryan Lawrence
package test;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Rule;
import org.junit.Test;
import layout.Ball;
import layout.Vector2d;
import javafx.scene.paint.Paint;

public class TestBallLayout {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestBallLayoutConstructor() {
		Ball ball = new Ball((float)1, (float)1, (float)3, (float)1);
		assertEquals(ball.position.getX(), (float)1, 0.0);
	}
	@Test
	public void TestBallLayoutGetBallColor() {
		Ball ball = new Ball((float)1, (float)1, (float)3, (float)1);
		assertEquals(ball.getBallColor((float)1000), Color.getHSBColor(0.38f, 0.98f, 0.95f));
	}
	@Test
	public void TestBallLayoutRadius() {
		Ball ball = new Ball((float)1, (float)1, (float)3, (float)1);
		ball.setRadius((float)47);
		assertEquals(ball.getRadius(), (float)47, 0.0);
	}
	@Test
	public void TestBallLayoutColliding() {
		Ball ball1 = new Ball((float)1, (float)1, (float)3, (float)1);
		Ball ball2 = new Ball((float)1, (float)1, (float)3, (float)1);
		assertEquals(ball1.colliding(ball2), true);
	}
	@Test
	public void TestBallLayoutMass() {
		Ball ball1 = new Ball((float)1, (float)1, (float)3, (float)1);
		Ball ball2 = new Ball((float)1, (float)1, (float)3, (float)1);
		assertEquals(ball1.compareTo(ball2), 0);
	}
}