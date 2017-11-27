// Author: Won Young Son
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Login;
import layout.Main;

public class TestLogin {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
//	@Test
//	public void TestLoginGetScreen() {
//		Main main = new Main();
//		Login login = new Login(main);
//		Scene scene = login.getScene();
//		assertTrue(scene instanceof Scene);
//	}
}