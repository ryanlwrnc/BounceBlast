// Author: Won Young Son
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.CreateAccount;
import layout.Main;

public class TestCreateAccount {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestCreateAccountGetScreen() {
		Main main = new Main();
		CreateAccount account = new CreateAccount(main);
		Scene scene = account.getScene();
		assertTrue(scene instanceof Scene);
	}
}