// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.MainMenu;

public class TestMainMenu {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestMainMenuGetScreen() {
		Main main = new Main();
		MainMenu mainMenu = new MainMenu(main);
		Scene scene = mainMenu.getScene();
		assertTrue(scene instanceof Scene);
	}
	@Test
	public void TestMainMenuLogIn() {
		Main main = new Main();
		MainMenu mainMenu = new MainMenu(main);
		mainMenu.logIn("username");
		assertEquals(mainMenu.getUsername(), "username");
	}
}