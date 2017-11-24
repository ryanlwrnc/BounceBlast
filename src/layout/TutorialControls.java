package layout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class TutorialControls extends Main implements CustomScreen {

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
        box.setPadding(new Insets(5,5,5,5));
        box.setMinWidth(520);
        box.setMaxHeight(300);
        box.setHgap(5);
        box.setVgap(5);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: white;-fx-border-width: 3;");
        
        Image moveImg = new Image("file:arrowKeys.png");
        ImageView moveView = new ImageView(moveImg);
        moveView.setFitHeight(110);
        moveView.setFitWidth(200);
        box.add(moveView, 0, 0);
        
        Text move = new Text();
        move.setFont(new Font(20));
        move.setFill(Color.WHITE);
        move.setText("Move");
        move.setStyle("-fx-font: 20 arial;");
        move.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(move, HPos.RIGHT);
		box.add(move, 1, 0);
		GridPane.setMargin(move, new Insets(5, 10, 5, 10));	
	
		Text accelerate = new Text();
		accelerate.setFont(new Font(20));
		accelerate.setFill(Color.WHITE);
		accelerate.setText("Accelerate");
		accelerate.setStyle("-fx-font: 20 arial;");
		accelerate.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(accelerate, HPos.RIGHT);
		box.add(accelerate, 1, 1);
		GridPane.setMargin(accelerate, new Insets(5, 10, 5, 10));	
		
		Image accelerateImg = new Image("file:spacebar.png");
        ImageView accelerateView = new ImageView(accelerateImg);
        accelerateView.setFitHeight(60);
        accelerateView.setFitWidth(200);
        box.add(accelerateView, 0, 1);
		
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
				CustomScreen tutorialRules = screenFactory.newScreen(ScreenFactory.ScreenType.TUTORIAL_RULES);
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
        controls.setStyle("-fx-background-color: #003399;" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: gray;-fx-border-width: 3;");
        Text controlsTitle = new Text();
        controlsTitle.setText("Controls");
        controlsTitle.setStyle("-fx-fill: #FFFFFF; -fx-font: 20 arial;");
        controlsTitle.setTextAlignment(TextAlignment.CENTER);
        controls.getChildren().add(controlsTitle);
        StackPane.setAlignment(controlsTitle, Pos.CENTER);
        gridpane.add(controls, 2, 1, 1, 1);
		
        StackPane strategy = new StackPane();
        strategy.setMinWidth(200);
		strategy.setMinHeight(50);
        strategy.setMaxWidth(200);
        strategy.setMaxHeight(50);
        strategy.setStyle("-fx-background-color: white;" +
				 "-fx-background-position:center top;" +
				 "-fx-border-color: gray;-fx-border-width: 3;");
        Text strategyTitle = new Text();
        strategyTitle.setText("Strategy");
        strategyTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
        strategyTitle.setTextAlignment(TextAlignment.CENTER);
        strategy.getChildren().add(strategyTitle);
        StackPane.setAlignment(strategyTitle, Pos.CENTER);
        gridpane.add(strategy, 3, 1, 1, 1);
        strategy.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				CustomScreen tutorialStrategy = screenFactory.newScreen(ScreenFactory.ScreenType.TUTORIAL_STRATEGY);
				updateScene(tutorialStrategy.getScene());
			}
		});
        strategy.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		strategy.setStyle("-fx-background-color: #003399;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		strategyTitle.setStyle("-fx-fill: #FFFFFF; -fx-font: 20 arial;");
	        }
	    });
        strategy.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		strategy.setStyle("-fx-background-color: white;" +
	       				 "-fx-background-position:center top;" +
	       				 "-fx-border-color: gray;-fx-border-width: 3;");
	        		strategyTitle.setStyle("-fx-fill: #000000; -fx-font: 20 arial;");
	        }
	    });
        
		gridpane.add(box, 1, 2, 3, 1);
		

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
				CustomScreen mainMenu = screenFactory.newScreen(ScreenFactory.ScreenType.MAIN_MENU);
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