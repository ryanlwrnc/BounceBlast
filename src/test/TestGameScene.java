package test;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import game.GameScene;
import javafx.scene.Scene;

public class TestGameScene {
	@Test
	public void TestGameSceneNotNull() {
		GameScene gameScene = new GameScene();
		Scene scene = gameScene.getScene();
		assertNotNull(scene);
	}
}