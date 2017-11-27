// Author: Won Young Son
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import layout.User;

public class TestUser {
	@Test
	public void TestUserConstructorWithPassword() {
		User user = new User("password");
		assertEquals(user.password, "password");
	}
	@Test
	public void TestUserConstructorWithPasswordAndUsername() {
		User user = new User("username", "password");
		assertEquals(user.username, "username");
	}
	@Test
	public void TestUserConstructorWithPasswordAndScore() {
		User user = new User("password", 100);
		assertEquals((int)user.score, 100);
	}
	@Test
	public void TestUserConstructorWithAll() {
		User user = new User("username", "password", 100);
		assertEquals((int)user.score, 100);
	}
}