// Author: Mark Toujiline
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import layout.Vector2d;

public class TestVector2d {
	@Test
	public void TestVector2dConstructor() {
		Vector2d v = new Vector2d((float)2, (float)2);
		assertEquals(v.getX(), (float)2, 0.0);
	}
	@Test
	public void TestVector2dX() {
		Vector2d v = new Vector2d((float)2, (float)2);
		v.setX((float)5);
		assertEquals(v.getX(), (float)5, 0.0);
	}
	@Test
	public void TestVector2dY() {
		Vector2d v = new Vector2d((float)2, (float)2);
		v.setY((float)5);
		assertEquals(v.getY(), (float)5, 0.0);
	}
	@Test
	public void TestVector2dSet() {
		Vector2d v = new Vector2d((float)2, (float)2);
		v.set((float)5, (float)5);
		assertEquals(v.getY(), (float)5, 0.0);
	}
	@Test
	public void TestVector2dDot() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = new Vector2d((float)1, (float)1);
		assertEquals(v1.dot(v2), (float)4, 0.0);
	}
	@Test
	public void TestVector2dGetLength() {
		Vector2d v = new Vector2d((float)2, (float)2);
		assertEquals(v.getLength(), (float)Math.sqrt(2*2 + 2*2), 0.0);
	}
	@Test
	public void TestVector2dGetDistance() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = new Vector2d((float)1, (float)1);
		assertEquals(v1.getDistance(v2), (float)Math.sqrt(1 + 1), 0.0);
	}
	@Test
	public void TestVector2dAdd() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = new Vector2d((float)1, (float)1);
		Vector2d v3 = v1.add(v2);
		assertEquals(v3.getX(), (float)3, 0.0);
	}
	@Test
	public void TestVector2dSubtract() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = new Vector2d((float)1, (float)1);
		Vector2d v3 = v1.subtract(v2);
		assertEquals(v3.getX(), (float)1, 0.0);
	}
	@Test
	public void TestVector2dMultiply() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = v1.multiply((float)2);
		assertEquals(v2.getX(), (float)4, 0.0);
	}
	@Test
	public void TestVector2dNormalize() {
		Vector2d v1 = new Vector2d((float)2, (float)2);
		Vector2d v2 = v1.normalize();
		float len = (float) Math.sqrt(2*2 + 2*2);
		assertEquals(v2.getX(), (float)2/len, 0.0);
	}
	@Test
	public void TestVector2dToString() {
		Vector2d v = new Vector2d((float)2, (float)2);
		assertEquals(v.toString(), "X: 2.0 Y: 2.0");
	}
}