package layout;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TutorialStrategy extends Main implements Screen {

	@Override
	public Scene getScene() {
		ScreenFactory screenFactory = new ScreenFactory();
		Button back;
		GridPane gridpane = new GridPane();
		
		final int numCols = 5 ;
        final int numRows = 5 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            colConst.setHgrow(Priority.ALWAYS);
            gridpane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            rowConst.setVgrow(Priority.ALWAYS);
            gridpane.getRowConstraints().add(rowConst);         
        }

		gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		 
		// BounceBlast text
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Tutorial");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, 2, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        GridPane box = new GridPane();
        box.setPadding(new Insets(22,5,22,5));
        box.setMaxWidth(400);
        box.setMaxHeight(300);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");
        
        Text strategyText = new Text();
        strategyText.setFont(new Font(10));
        strategyText.setFill(Color.WHITE);
        strategyText.setWrappingWidth(484);
        strategyText.setText("- Each ball has a different weight and the ability to accelerate at different speeds.\nBasketball:\n" +
        		"- This ball is tha largest and slowest ball in the game.\n- Its weight prevents it from bouncing very much and it " +
        		"difficult to control its acceleration.\n\nSoccer Ball:\n- This ball has the least elasticity of all " +
        		"balls and bounces the least, but absorbs the most force from other balls." +
        		"\n\nTennis Ball:\n- This is the fastest and lightest ball in the game.\n- It has the advantage of easily " +
        		"dodging other balls and hitting them back with high speed and accuracy.\n\nBaseball:\n- This is the " +
        		"second lightest ball in the game.\n- It has a high weight for its size and does not bounce very much, but can " +
        		"hit other balls with high force.");
        strategyText.setStyle("-fx-font: 12 arial;");
        strategyText.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(strategyText, HPos.LEFT);
		box.add(strategyText, 0, 0);
		GridPane.setMargin(strategyText, new Insets(5, 10, 5, 10));	
		
		StackPane rules = new StackPane();
		rules.setMinWidth(200);
        rules.setMinHeight(50);
		rules.setMaxWidth(200);
        rules.setMaxHeight(50);
        rules.setStyle("-fx-background-color: white;" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: gray;-fx-border-width: 3;");
        Text rulesTitle = new Text();
        rulesTitle.setText("Rules");
        rulesTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
        rulesTitle.setTextAlignment(TextAlignment.CENTER);
        rules.getChildren().add(rulesTitle);
        StackPane.setAlignment(rulesTitle, Pos.CENTER);
        gridpane.add(rules, 1, 1, 1, 1);
        rules.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Screen tutorialRules = screenFactory.newScreen(ScreenFactory.ScreenType.TUTORIAL_RULES);
				updateScene(tutorialRules.getScene());
			}
		});
        rules.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		rules.setStyle("-fx-background-color: #003399;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		rulesTitle.setStyle("-fx-fill: #FFFFFF; -fx-font: 20 arial;");
	        }
	    });
        rules.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		rules.setStyle("-fx-background-color: white;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		rulesTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
	        }
	    });
        
        StackPane controls = new StackPane();
		controls.setMinWidth(200);
        controls.setMinHeight(50);
        controls.setMaxWidth(200);
        controls.setMaxHeight(50);
        controls.setStyle("-fx-background-color: white;" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: gray;-fx-border-width: 3;");
        Text controlsTitle = new Text();
        controlsTitle.setText("Controls");
        controlsTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
        controlsTitle.setTextAlignment(TextAlignment.CENTER);
        controls.getChildren().add(controlsTitle);
        StackPane.setAlignment(controlsTitle, Pos.CENTER);
        gridpane.add(controls, 2, 1, 1, 1);
        controls.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Screen tutorialControls = screenFactory.newScreen(ScreenFactory.ScreenType.TUTORIAL_CONTROLS);
				updateScene(tutorialControls.getScene());
			}
		});
        controls.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		controls.setStyle("-fx-background-color: #003399;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		controlsTitle.setStyle("-fx-fill: #FFFFFF; -fx-font: 20 arial;");
	        }
	    });
        controls.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		controls.setStyle("-fx-background-color: white;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		controlsTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
	        }
	    });
		
        StackPane strategy = new StackPane();
        strategy.setMinWidth(200);
		strategy.setMinHeight(50);
        strategy.setMaxWidth(200);
        strategy.setMaxHeight(50);
        strategy.setStyle("-fx-background-color: #003399;" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: gray;-fx-border-width: 3;");
        Text strategyTitle = new Text();
        strategyTitle.setText("Strategy");
        strategyTitle.setStyle("-fx-fill: #FFFFFF; -fx-font: 20 arial;");
        strategyTitle.setTextAlignment(TextAlignment.CENTER);
        strategy.getChildren().add(strategyTitle);
        StackPane.setAlignment(strategyTitle, Pos.CENTER);
        gridpane.add(strategy, 3, 1, 1, 1);
        
        
		gridpane.add(box, 1, 2, 3, 2);
		

		// Back button
		back = new Button("Back");
		back.setPrefHeight(25);
		back.setPrefWidth(65);
		back.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
		// Exit the application when exit pressed
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Screen mainMenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
				updateScene(mainMenu.getScene());
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