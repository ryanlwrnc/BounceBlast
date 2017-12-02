// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;

import layout.Main;
import layout.MainMenu;

public class TestMainMenu {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void testMainMenuLogIn() {
		Main main = new Main();
		MainMenu mainMenu = new MainMenu(main);
		mainMenu.logIn("username");
		assertEquals(mainMenu.getUsername(), "username");
	}
}