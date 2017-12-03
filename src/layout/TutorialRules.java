package layout;
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
import layout.components.BackToMainMenuButton;

public class TutorialRules extends Scene {

	// JavaFX
	private GridPane gridpane;
	
	// Components
	BackToMainMenuButton back;
	private StackPane controls;
	
	// Constants
	static final int NUMCOLS = 5 ;
    static final int NUMROWS = 5 ;
	private static final String BACKGROUNDPOSITIONCENTERTOP = "-fx-background-position:center top;";
	private static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	private static final String FONT20 = "-fx-font: 20 arial;";
	private static final String BACKGROUNDCOLORWHITE = "-fx-background-color: white;";
	private static final String BACKGROUNDCOLOR003399 ="-fx-background-color: #003399;";
	private static final String BORDERCOLORGRAY = "-fx-border-color: gray;";
	private static final String FILL000000 ="-fx-fill: #000000;";
	private static final String FILLFFFFFF ="-fx-fill: #FFFFFF;";
	
	public TutorialRules(Main app) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
		
        for (int i = 0; i < NUMCOLS; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / NUMCOLS);
            colConst.setHgrow(Priority.ALWAYS);
            gridpane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < NUMROWS; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / NUMROWS);
            rowConst.setVgrow(Priority.ALWAYS);
            gridpane.getRowConstraints().add(rowConst);         
        }
		/*ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        gridpane.getColumnConstraints().add(cons1);

        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        ColumnConstraints cons3 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        gridpane.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.ALWAYS);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        gridpane.getRowConstraints().addAll(rcons1, rcons2);*/
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
        box.setPadding(new Insets(44,5,44,5));
        box.setMaxWidth(400);
        box.setMaxHeight(300);
        box.setHgap(5);
        box.setVgap(5);
        //box.getColumnConstraints().addAll(cons1, cons2);
        //box.getRowConstraints().addAll(rcons1, rcons2);
        box.setStyle("-fx-background-color: rgba(0, 0, 128, 0.4);" +
        		BACKGROUNDPOSITIONCENTERTOP +
				 "-fx-border-color: white;"
				 + BORDERWIDTH3);
        
        Text rulesText = new Text();
        rulesText.setFont(new Font(20));
        rulesText.setFill(Color.WHITE);
        rulesText.setWrappingWidth(484);
        rulesText.setText("- Each game consists of five rounds\n- There are four " + 
        		"different types of sports balls to choose from\n	    - Basketball, " +
        		"soccer ball, football, and tennis ball\n- The objective of the game " +
        		"is to push the opponent's ball toward the POD (Platform of Death)\n" +
        		"- The player with the most points after five rounds is the winner");
        rulesText.setStyle(FONT20);
        rulesText.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(rulesText, HPos.LEFT);
		box.add(rulesText, 0, 0);
		GridPane.setMargin(rulesText, new Insets(5, 10, 5, 10));	
		
		StackPane rules = new StackPane();
		rules.setMinWidth(200);
        rules.setMinHeight(50);
		rules.setMaxWidth(200);
        rules.setMaxHeight(50);
        rules.setStyle(BACKGROUNDCOLOR003399 +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY
				 + BORDERWIDTH3);
        Text rulesTitle = new Text();
        rulesTitle.setText("Rules");
        rulesTitle.setStyle(FILLFFFFFF
        		+ FONT20);
        rulesTitle.setTextAlignment(TextAlignment.CENTER);
        rules.getChildren().add(rulesTitle);
        StackPane.setAlignment(rulesTitle, Pos.CENTER);
        gridpane.add(rules, 1, 1, 1, 1);
        
        controls = new StackPane();
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
        strategy.setStyle(BACKGROUNDCOLORWHITE +
        		BACKGROUNDPOSITIONCENTERTOP +
				 BORDERCOLORGRAY
				 + BORDERWIDTH3);
        Text strategyTitle = new Text();
        strategyTitle.setText("Strategy");
        strategyTitle.setStyle(FILL000000
        		+ FONT20);
        strategyTitle.setTextAlignment(TextAlignment.CENTER);
        strategy.getChildren().add(strategyTitle);
        StackPane.setAlignment(strategyTitle, Pos.CENTER);
        gridpane.add(strategy, 3, 1, 1, 1);
        strategy.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				app.updateScene(new TutorialStrategy(app));
			}
		});
        strategy.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		strategy.setStyle(BACKGROUNDCOLOR003399 +
	        				BACKGROUNDPOSITIONCENTERTOP +
	       				 BORDERCOLORGRAY
	       				 + BORDERWIDTH3);
	        		strategyTitle.setStyle(FILLFFFFFF
	        				+ FONT20);
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
        
        GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, 1, 2, 3, 2);
		

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