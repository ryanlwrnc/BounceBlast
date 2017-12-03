package test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import javafx.scene.layout.GridPane;
import layout.Main;
import layout.TutorialStrategy;

public class TestLoopTutorialStrategy {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testLoopTutorialStrategyNumCols() {
		Main main = new Main();
		TutorialStrategy tutorialStrategy = new TutorialStrategy(main);
		GridPane gridpane = tutorialStrategy.getGridpane();
		int numCols = gridpane.getColumnCount();
		assertEquals(numCols, 5);
	}
}
