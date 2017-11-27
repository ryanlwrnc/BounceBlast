// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import layout.Main;
import layout.MainMenu;
import layout.ScreenFactory;
import layout.ScreenFactory.ScreenType;

public class TestScreenFactory {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestCreateAccountNewScreen() {
		Main main = new Main();
		ScreenFactory screenFactory = new ScreenFactory(main);
		assertTrue(screenFactory.newScreen(ScreenType.MAIN_MENU) instanceof MainMenu);
	}
}