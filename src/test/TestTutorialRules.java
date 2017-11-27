// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.TutorialRules;

public class TestTutorialRules {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestTutorialRulesGetScreen() {
		Main main = new Main();
		TutorialRules tutorialRules = new TutorialRules(main);
		Scene scene = tutorialRules.getScene();
		assertTrue(scene instanceof Scene);
	}
}