// Author: Won Young Son
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import layout.User;

public class TestUser {
	private static final String UN = "username";
	private static final String PW = "password";
	@Test
	public void testUserConstructorWithPassword() {
		User user = new User(PW);
		assertEquals(user.getPassword(), PW);
	}
	@Test
	public void testUserConstructorWithPasswordAndUsername() {
		User user = new User(UN, PW);
		assertEquals(user.getUsername(), UN);
	}
	@Test
	public void testUserConstructorWithPasswordAndScore() {
		User user = new User(PW, 100);
		assertEquals((int)user.getScore(), 100);
	}
	@Test
	public void testUserConstructorWithAll() {
		User user = new User(UN, PW, 100);
		assertEquals((int)user.getScore(), 100);
	}
}