// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.TutorialControls;

public class TestTutorialControls {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	/*
	@Test
	public void TestTutorialControlsGetScreen() {
		Main main = new Main();
		TutorialControls tutorialControls = new TutorialControls(main);
		Scene scene = tutorialControls.getScene();
		assertTrue(scene instanceof Scene);
	}
	*/
}