// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.TutorialStrategy;

public class TestTutorialStrategy {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestTutorialStrategyGetScreen() {
		Main main = new Main();
		TutorialStrategy tutorialStrategy = new TutorialStrategy(main);
		Scene scene = tutorialStrategy.getScene();
		assertTrue(scene instanceof Scene);
	}
	*/
}