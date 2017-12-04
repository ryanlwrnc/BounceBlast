package layout;
import game.GameEngine;
import game.GameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class PlayOffline extends Scene {
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton back;
	private Button start;
	private GridPane box;
	private Text numCPULabel;
	private ComboBox<String> cbCPU;
	private ComboBox<String> cbBall;
	
	// Constants
	public static final int SCREENBUTTONCOL = 2;
	public static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	public static final String BORDERCOLORWHITE = "-fx-border-color: white;";
	public static final String BACKGROUNDCOLOR24618F = "-fx-background-color: #24618F;";
	public static final String FONTSIZE16 = "-fx-font-size: 16;";
	public static final String TEXTFILLWHITE = "-fx-text-fill: white;";
	
	public PlayOffline(Main app) {
		super(new GridPane(), 800, 600);
		
		gridpane = (GridPane) getRoot();
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		
		 
		// BounceBlast text
		gridpane = screenHelper.setTitle(gridpane, "Play Offline", SCREENBUTTONCOL);
		
		 //Adding GridPane
        box = new GridPane();
        box.setPadding(new Insets(20,20,20,20));
        box.setMaxWidth(650);
        box.setMaxHeight(250);
        box.setHgap(5);
        box.setVgap(5);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 BORDERCOLORWHITE + BORDERWIDTH3);
        
       numCPULabel = new Text();
       numCPULabel.setFont(new Font(20));
       numCPULabel.setFill(Color.WHITE);
       numCPULabel.setText("Number of CPUs");
       numCPULabel.setStyle("-fx-font: 30 arial;");
       numCPULabel.setTextAlignment(TextAlignment.LEFT);
		 GridPane.setHalignment(numCPULabel, HPos.LEFT);
		 box.add(numCPULabel, 0, 0);
		 GridPane.setMargin(numCPULabel, new Insets(5, 10, 5, 10));	
		
		 cbCPU = new ComboBox<>();
		 cbCPU.getItems().add("1");
		 cbCPU.getItems().add("2");
		 cbCPU.getItems().add("3");
	    box.add(cbCPU, 1, 0);

	    gridpane = screenHelper.setupPlayGame(gridpane, box, SCREENBUTTONCOL);
	    cbBall = screenHelper.getCbBall();
	    
		// Start Button
		start = new Button("Start");
		start.setPrefHeight(25);
		start.setPrefWidth(65);
		start.setStyle(BORDERWIDTH3 + 
				BORDERCOLORWHITE + 
				BACKGROUNDCOLOR24618F +
				FONTSIZE16 + 
				TEXTFILLWHITE);
		gridpane.add(start, 2, 5);
		GridPane.setHalignment(start, HPos.CENTER);
		GridPane.setMargin(start, new Insets(5, 80, 30, 10));
		// Return to Main Menu when back is pressed
		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Make sure NumberOfCPUs and SelectGameBall are selected
				if(cbBall.getValue() != null & cbCPU.getValue() != null) {

					// Create a new GameScene, that is created based on what the users ball is as well as the number of CPUs.
					GameScene scene = new GameScene(app, cbCPU.getValue(), cbBall.getValue());

					app.updateScene(scene);
					
					app.setThread(new Thread(new GameEngine(app, scene,cbCPU.getValue())));
					Thread mainThread = app.getThread();
					mainThread.start();
				}
			}
		});
		
		start.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	start.setStyle(BORDERWIDTH3 + 
	        			BORDERCOLORWHITE + 
	        				"-fx-background-color: #003399;" +
	        				FONTSIZE16 + 
	        				TEXTFILLWHITE);
	        }
	    });

		start.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	start.setStyle(BORDERWIDTH3 + 
	        			BORDERCOLORWHITE + 
	        				BACKGROUNDCOLOR24618F +
	        				FONTSIZE16 + 
	        				TEXTFILLWHITE);
	        }
	    });
		
		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 1, 10);
		 	
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));

		
		// Go to the temporary game scene when the button is pressed.
		
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}