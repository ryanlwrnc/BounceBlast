package layout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PlayOnline extends Main implements Screen {

	@Override
	public Scene getScene() {
		// TODO Auto-generated method stub
		Button back, start;
		ScreenFactory screenFactory = new ScreenFactory();
		int screenButtonCol = 2;
		GridPane gridpane = new GridPane();
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
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Play Online");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        GridPane box = new GridPane();
        box.setPadding(new Insets(20,20,20,20));
        box.setMaxWidth(650);
        box.setMaxHeight(250);
        box.setHgap(5);
        box.setVgap(5);
        box.getColumnConstraints().addAll(cons1, cons2);
        box.getRowConstraints().addAll(rcons1, rcons2);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");
        
        
		Text directionKeys = new Text();
		directionKeys.setFont(new Font(20));
		directionKeys.setFill(Color.WHITE);
		directionKeys.setText("CPUs");
		directionKeys.setStyle("-fx-font: 30 arial;");
		directionKeys.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(directionKeys, HPos.LEFT);
		box.add(directionKeys, 0, 0);
		GridPane.setMargin(directionKeys, new Insets(5, 10, 5, 200));	
		
		ComboBox<String> cbCPU = new ComboBox<String>();
        cbCPU.getItems().add("0");
        cbCPU.getItems().add("1");
        cbCPU.getItems().add("2");
        cbCPU.getItems().add("3");
	    box.add(cbCPU, 1, 0);
	    
	    Text ballTypes = new Text();
	    ballTypes.setFont(new Font(20));
	    ballTypes.setFill(Color.WHITE);
	    ballTypes.setText("Balls");
	    ballTypes.setStyle("-fx-font: 30 arial;");
	    ballTypes.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(ballTypes, HPos.LEFT);
		box.add(ballTypes, 0, 1);
		GridPane.setMargin(ballTypes, new Insets(5, 10, 5, 200));	
		
		ComboBox<String> cbBall = new ComboBox<String>();
        cbBall.getItems().add("Basketball");
        cbBall.getItems().add("Bowling Ball");
        cbBall.getItems().add("Tennis Ball");
	    box.add(cbBall, 1, 1);
		
		gridpane.add(box, screenButtonCol, 1);

		// Start Button
		start = new Button("Start");
		start.setPrefHeight(25);
		start.setPrefWidth(65);
		start.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(start, 2, 5);
		GridPane.setHalignment(start, HPos.CENTER);
		GridPane.setMargin(start, new Insets(5, 10, 5, 10));
		// Return to Main Menu when back is pressed
		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Screen ingame = screenFactory.newScreen(ScreenFactory.ScreenType.IN_GAME);
				updateScene(ingame.getScene());
			}
		});
		start.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	start.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		start.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        	start.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #24618F;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });
		
		// Back button
		back = new Button("Back");
		back.setPrefHeight(25);
		back.setPrefWidth(65);
		back.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		// Return to Main Menu when back is pressed
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Screen mainmenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				updateScene(mainmenu.getScene());
			}
		});
		back.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		back.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		back.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		back.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #24618F;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });
		 
		Scene scene = new Scene(gridpane, 800, 600);
		return scene;
		
	}

}
