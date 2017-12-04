package layout;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import layout.components.BackToMainMenuButton;

public class TutorialControls extends Scene {

	// JavaFX
	private GridPane gridpane;

	// Components
	BackToMainMenuButton back;
	
	// Constants
	private static final String BACKGROUNDPOSITIONCENTERTOP = "-fx-background-position:center top;";
	private static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	private static final String BACKGROUNDCOLORWHITE = "-fx-background-color: white;";
	private static final String BACKGROUNDCOLOR003399 ="-fx-background-color: #003399;";
	private static final String BORDERCOLORGRAY = "-fx-border-color: gray;";
	private static final String FILL000000 ="-fx-fill: #000000;";
	private static final String FILLFFFFFF ="-fx-fill: #FFFFFF;";
	private static final String FONT20 = "-fx-font: 20 arial;";
	
	
	public TutorialControls(Main app) {
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
            rowConst.setVgrow(Priority.ALWAYS);
            rowConst.setPercentHeight(100.0 / numRows);
            gridpane.getRowConstraints().add(rowConst);         
        }
        
		gridpane.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		gridpane.setAlignment(Pos.TOP_CENTER);
		 
		// BounceBlast text
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setFill(Color.WHITE);
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		gameTitle.setText("Tutorial");
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, 2, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		 //Adding GridPane
        GridPane box = new GridPane();
        box.setMinWidth(520);
        box.setPadding(new Insets(5,5,5,5));
        box.setMaxHeight(300);
        box.setHgap(5);
        box.setVgap(5);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
        		BACKGROUNDPOSITIONCENTERTOP +
			"-fx-border-color: white;" +
			BORDERWIDTH3);
        
        Image moveImg = new Image("file:resource/arrowKeys.png");
        ImageView moveView = new ImageView(moveImg);
        moveView.setFitHeight(110);
        moveView.setFitWidth(200);
        box.add(moveView, 0, 0);
        
        Text move = new Text();
        move.setFont(new Font(20));
        move.setFill(Color.WHITE);
        move.setText("Move");
        move.setStyle(FONT20);
        move.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(move, HPos.RIGHT);
		box.add(move, 1, 0);
		GridPane.setMargin(move, new Insets(5, 10, 5, 10));	
	
		Text accelerate = new Text();
		accelerate.setFont(new Font(20));
		accelerate.setFill(Color.WHITE);
		accelerate.setText("Accelerate");
		accelerate.setStyle(FONT20);
		accelerate.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(accelerate, HPos.RIGHT);
		box.add(accelerate, 1, 1);
		GridPane.setMargin(accelerate, new Insets(5, 10, 5, 10));	
		
		Image accelerateImg = new Image("file:resource/spacebar.png");
        ImageView accelerateView = new ImageView(accelerateImg);
        accelerateView.setFitHeight(60);
        accelerateView.setFitWidth(200);
        box.add(accelerateView, 0, 1);
		
		StackPane rules = new StackPane();
		rules.setMinWidth(200);
        rules.setMinHeight(50);
		rules.setMaxWidth(200);
        rules.setMaxHeight(50);
        rules.setStyle(BACKGROUNDCOLORWHITE +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY +
				 BORDERWIDTH3);
        Text rulesTitle = new Text();
        rulesTitle.setText("Rules");
        rulesTitle.setStyle(FILL000000 +
        		FONT20);
        rulesTitle.setTextAlignment(TextAlignment.CENTER);
        rules.getChildren().add(rulesTitle);
        StackPane.setAlignment(rulesTitle, Pos.CENTER);
        gridpane.add(rules, 1, 1, 1, 1);
        /*
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
	       				 BORDERCOLORGRAY +
	       				BORDERWIDTH3);
	        		rulesTitle.setStyle(FILLFFFFFF
	        				+ FONT20);
	        }
	    });
        rules.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		rules.setStyle(BACKGROUNDCOLORWHITE +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY +
	       				BORDERWIDTH3);
	        		rulesTitle.setStyle(FILL000000
	        				+ FONT20);
	        }
	    });*/
        ScreenHelper screenHelper = new ScreenHelper();
        rules = screenHelper.tutorialButton(app, rules, rulesTitle);
        rulesTitle = screenHelper.getRulesTitle();
        
        StackPane controls = new StackPane();
		controls.setMinWidth(200);
        controls.setMinHeight(50);
        controls.setMaxWidth(200);
        controls.setMaxHeight(50);
        controls.setStyle(BACKGROUNDCOLOR003399 +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY +
				 BORDERWIDTH3);
        Text controlsTitle = new Text();
        controlsTitle.setText("Controls");
        controlsTitle.setStyle(FILLFFFFFF
        		+ FONT20);
        controlsTitle.setTextAlignment(TextAlignment.CENTER);
        controls.getChildren().add(controlsTitle);
        StackPane.setAlignment(controlsTitle, Pos.CENTER);
        gridpane.add(controls, 2, 1, 1, 1);
		
        StackPane strategy = new StackPane();
		strategy.setMinHeight(50);
        strategy.setMaxWidth(200);
        strategy.setMinWidth(200);
        strategy.setMaxHeight(50);
        strategy.setStyle(BACKGROUNDCOLORWHITE +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY +
				 BORDERWIDTH3);
        Text strategyTitle = new Text();
        strategyTitle.setText("Strategy");
        strategyTitle.setTextAlignment(TextAlignment.CENTER);
        strategyTitle.setStyle(FILL000000
        		+ FONT20);
        strategy.getChildren().add(strategyTitle);
        StackPane.setAlignment(strategyTitle, Pos.CENTER);
        gridpane.add(strategy, 3, 1, 1, 1);
        strategy.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		strategyTitle.setStyle(FILLFFFFFF
	        				+ FONT20);
	        		strategy.setStyle(BACKGROUNDCOLOR003399 +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY +
	       				BORDERWIDTH3);
	        }
	    });
        strategy.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		strategy.setStyle(BACKGROUNDCOLORWHITE +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		strategyTitle.setStyle(FILL000000
	        				+ FONT20);
	        }
	    });
        strategy.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				app.updateScene(new TutorialStrategy(app));
			}
		});
        /*screenHelper = new ScreenHelper();
        strategy = screenHelper.tutorialButton(app, strategy, strategyTitle);
        strategyTitle = screenHelper.getRulesTitle();*/
        
        GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, 1, 2, 3, 1);
		

		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 0, 4);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
	}	
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}