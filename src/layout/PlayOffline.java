package layout;
import game.GameEngine;
import game.GameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;
import layout.components.PlayOnlineButton;

public class PlayOffline extends Scene {

	// JavaFX
	private GridPane gridpane;
	
	// Components
	private Button back;
	private Button start;
	private Button temp;
	private Text gameTitle;
	private Text ballTypes;
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
		ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        gridpane.getColumnConstraints().add(cons1);

        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        gridpane.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        gridpane.getRowConstraints().addAll(rcons1, rcons2);
		gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		 
		// BounceBlast text
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Play Offline");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, SCREENBUTTONCOL, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        box = new GridPane();
        box.setPadding(new Insets(20,20,20,20));
        box.setMaxWidth(650);
        box.setMaxHeight(250);
        box.setHgap(5);
        box.setVgap(5);
        box.getColumnConstraints().addAll(cons1, cons2);
        box.getRowConstraints().addAll(rcons1, rcons2);
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
	    
	    ballTypes = new Text();
	    ballTypes.setFont(new Font(20));
	    ballTypes.setFill(Color.WHITE);
	    ballTypes.setText("Select Your Game Ball");
	    ballTypes.setStyle("-fx-font: 30 arial;");
	    ballTypes.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(ballTypes, HPos.LEFT);
		box.add(ballTypes, 0, 1);
		GridPane.setMargin(ballTypes, new Insets(5, 10, 5, 10));	
		
		cbBall = new ComboBox<>();
        cbBall.getItems().add("Basketball");
        cbBall.getItems().add("Bowling Ball");
        cbBall.getItems().add("Tennis Ball");
        cbBall.getItems().add("Soccer Ball");
	    box.add(cbBall, 1, 1);
	    
	    GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, SCREENBUTTONCOL, 1);

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
				app.updateScene(new InGame(app));
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
		 
		//Temporary GameScene Button
		temp = new Button("Game Scene");
		temp.setPrefHeight(25);
		temp.setPrefWidth(200);
		temp.setStyle(BORDERWIDTH3 + 
				BORDERCOLORWHITE + 
				BACKGROUNDCOLOR24618F +
				FONTSIZE16 + 
				TEXTFILLWHITE);
		gridpane.add(temp, 2, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		
		//Temporary GameScene Button
		temp = new PlayOnlineButton(app, "Game Scene", new GameScene());
		temp.setPrefHeight(25);
		temp.setPrefWidth(200);
		
		gridpane.add(temp, 2, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		
		// Go to the temporary game scene when the button is pressed.
		temp.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				// Make sure NumberOfCPUs and SelectGameBall are selected
				if(cbBall.getValue() != null & cbCPU.getValue() != null) {

					GameScene scene = new GameScene(cbCPU.getValue(), cbBall.getValue());
					app.updateScene(scene);
			        Main.thread = new Thread(new GameEngine(scene));
			        Main.thread.start();
				}
			}
		});
		
	}
}