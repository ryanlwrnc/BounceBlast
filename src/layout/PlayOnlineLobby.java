package layout;
import game.GameEngine;
import game.GameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import layout.components.BackToMainMenuButton;
import layout.components.PlayOnlineButton;

public class PlayOnlineLobby extends Scene {
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Button start;
	private Button temp;
	private Button settings;
	private GridPane box;
	private ColumnConstraints cons1;
	private ColumnConstraints cons2;
	private RowConstraints rcons1;
	private RowConstraints rcons2;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	public PlayOnlineLobby(Main app) {
		super(new GridPane(), 800, 600);
		this.gridpane =  (GridPane) getRoot();
		
		// Gridpane
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		 
		// BounceBlast text
		GridPane[] gridpanes = screenHelper.titleAndBox(gridpane, rcons1, rcons2,
    			cons1, cons2, SCREENBUTTONCOL, "Play Online");
        gridpane = gridpanes[0];
        box = gridpanes[1];
		
	    GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, SCREENBUTTONCOL, 1);

		// Start Button
		start = new PlayOnlineButton(app, "Start", new InGame(app));
		start.setPrefHeight(25);
		start.setPrefWidth(65);
		start.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(start, 2, 5);
		GridPane.setHalignment(start, HPos.CENTER);
		GridPane.setMargin(start, new Insets(5, 80, 30, 10));
		
		// Lobby menu button
		settings = new PlayOnlineButton(app, "Settings", new Settings(app));
		settings.setPrefHeight(25);
		settings.setPrefWidth(100);
		settings.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(settings, 2, 4);
		GridPane.setHalignment(settings, HPos.CENTER);
		GridPane.setMargin(settings, new Insets(5, 80, 30, 10));	
		
		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		// Return to Main Menu when back is pressed
		
		//Temporary GameScene Button
		temp = new PlayOnlineButton(app, "Game Scene", new GameScene(app, "1", "Basketball"));
		temp.setPrefHeight(25);
		temp.setPrefWidth(200);
		gridpane.add(temp, 2, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		// Return to Main Menu when back is pressed
		temp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				GameScene scene = new GameScene(app, "1", "Basketball");
				app.updateScene(scene);
				
				app.setThread(new Thread(new GameEngine(app, scene, "3")));
				Thread mainThread = app.getThread();
				mainThread.start();
			}
		});
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}
