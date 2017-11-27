// Author: Won Young Son
package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.Scene;
import layout.Main;
import layout.Profile;

public class TestProfile {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void TestProfileGetScreen() {
		Main main = new Main();
		Profile profile = new Profile(main);
		Scene scene = profile.getScene();
		assertTrue(scene instanceof Scene);
	}
}