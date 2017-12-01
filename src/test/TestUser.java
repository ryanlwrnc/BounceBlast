// Author: Won Young Son
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import layout.User;

public class TestUser {
	@Test
	public void testUserConstructorWithPassword() {
		User user = new User("password");
		assertEquals(user.getPassword(), "password");
	}
	@Test
	public void testUserConstructorWithPasswordAndUsername() {
		User user = new User("username", "password");
		assertEquals(user.getUsername(), "username");
	}
	@Test
	public void testUserConstructorWithPasswordAndScore() {
		User user = new User("password", 100);
		assertEquals((int)user.getScore(), 100);
	}
	@Test
	public void testUserConstructorWithAll() {
		User user = new User("username", "password", 100);
		assertEquals((int)user.getScore(), 100);
	}
}