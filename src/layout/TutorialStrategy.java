package layout;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import layout.components.BackToMainMenuButton;

public class TutorialStrategy extends Scene {

	// JavaFX
	private GridPane gridpane;
	
	// Components
	BackToMainMenuButton back;
	
	// Constants
	private static final String BACKGROUNDPOSITIONCENTERTOP = "-fx-background-position:center top;";
	private static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	private static final String FONT20 = "-fx-font: 20 arial;";
	private static final String BACKGROUNDCOLORWHITE = "-fx-background-color: white;";
	private static final String BACKGROUNDCOLOR003399 ="-fx-background-color: #003399;";
	private static final String BORDERCOLORGRAY = "-fx-border-color: gray;";
	private static final String FILL000000 ="-fx-fill: #000000;";
	private static final String FILLFFFFFF ="-fx-fill: #FFFFFF;";
	
	public TutorialStrategy(Main app) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
		
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
		gridpane.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
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
        		BACKGROUNDPOSITIONCENTERTOP +
				 "-fx-border-color: white;"
				 + BORDERWIDTH3);
        
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
        rules.setStyle(BACKGROUNDCOLORWHITE +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY
				 + BORDERWIDTH3);
        Text rulesTitle = new Text();
        rulesTitle.setText("Rules");
        rulesTitle.setStyle(FILL000000
        		+ FONT20);
        rulesTitle.setTextAlignment(TextAlignment.CENTER);
        rules.getChildren().add(rulesTitle);
        StackPane.setAlignment(rulesTitle, Pos.CENTER);
        gridpane.add(rules, 1, 1, 1, 1);
        rules.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				app.updateScene(new TutorialRules(app));
			}
		});
        rules.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		rules.setStyle(BACKGROUNDCOLOR003399 +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		rulesTitle.setStyle(FILLFFFFFF
	        				+ FONT20);
	        }
	    });
        rules.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		rules.setStyle(BACKGROUNDCOLORWHITE +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		rulesTitle.setStyle(FILL000000
	        				+ FONT20);
	        }
	    });
        
        StackPane controls = new StackPane();
		controls.setMinWidth(200);
        controls.setMinHeight(50);
        controls.setMaxWidth(200);
        controls.setMaxHeight(50);
        controls.setStyle(BACKGROUNDCOLORWHITE +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY
				 + BORDERWIDTH3);
        Text controlsTitle = new Text();
        controlsTitle.setText("Controls");
        controlsTitle.setStyle(FILL000000
        		+ FONT20);
        controlsTitle.setTextAlignment(TextAlignment.CENTER);
        controls.getChildren().add(controlsTitle);
        StackPane.setAlignment(controlsTitle, Pos.CENTER);
        gridpane.add(controls, 2, 1, 1, 1);
        controls.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				app.updateScene(new TutorialControls(app));
			}
		});
        controls.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		controls.setStyle(BACKGROUNDCOLOR003399 +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		controlsTitle.setStyle(FILLFFFFFF
	        				+ FONT20);
	        }
	    });
        controls.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		controls.setStyle(BACKGROUNDCOLORWHITE +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		controlsTitle.setStyle(FILL000000
	        				+ FONT20);
	        }
	    });
		
        StackPane strategy = new StackPane();
        strategy.setMinWidth(200);
		strategy.setMinHeight(50);
        strategy.setMaxWidth(200);
        strategy.setMaxHeight(50);
        strategy.setStyle(BACKGROUNDCOLOR003399 +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY
				 + BORDERWIDTH3);
        Text strategyTitle = new Text();
        strategyTitle.setText("Strategy");
        strategyTitle.setStyle(FILLFFFFFF
        		+ FONT20);
        strategyTitle.setTextAlignment(TextAlignment.CENTER);
        strategy.getChildren().add(strategyTitle);
        StackPane.setAlignment(strategyTitle, Pos.CENTER);
        gridpane.add(strategy, 3, 1, 1, 1);
        
        GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, 1, 2, 3, 2);

		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));

	}
	public GridPane getGridpane() {
		return this.gridpane;
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}