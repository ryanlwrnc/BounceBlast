package layout;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
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

public class ScreenHelper {
	// Constants
	private static final String BACKGROUNDPOSITIONCENTERTOP = "-fx-background-position:center top;";
	private static final String BORDERWIDTH3 = "-fx-border-width: 3;";
	private static final String FONT20 = "-fx-font: 20 arial;";
	private static final String BACKGROUNDCOLORWHITE = "-fx-background-color: white;";
	private static final String BACKGROUNDCOLOR003399 ="-fx-background-color: #003399;";
	private static final String BORDERCOLORGRAY = "-fx-border-color: gray;";
	private static final String FILL000000 ="-fx-fill: #000000;";
	private static final String FILLFFFFFF ="-fx-fill: #FFFFFF;";
	private Text rulesTitle;
	
	ComboBox<String> cbBall = new ComboBox<>();
	public GridPane setupGridpane(GridPane gridpane) {
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
        gridpane.getRowConstraints(
        		).addAll(rcons1, rcons2);
		
        gridpane.setAlignment(Pos.TOP_CENTER);
		gridpane.setStyle("-fx-background-image: url('file:resource/background.jpg');" +
				 "-fx-background-size: stretch;-fx-background-position:center top;");
		return gridpane;
	}
	public GridPane[] titleAndBox(GridPane gridpane, RowConstraints rcons1, RowConstraints rcons2,
			ColumnConstraints cons1, ColumnConstraints cons2, int sCREENBUTTONCOL, String title) {
		GridPane[] gridpanes = new GridPane[2];
		//GridPane newGridpane = gridpane;
		gridpane = setTitle(gridpane, title, sCREENBUTTONCOL);
		/*Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("Settings");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, sCREENBUTTONCOL, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));*/
		
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
        gridpanes[0] = gridpane;
        gridpanes[1] = box;
        return gridpanes;
	}
	public GridPane setTitle(GridPane gridpane, String title, int sCREENBUTTONCOL) {
		Text gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText(title);
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, sCREENBUTTONCOL, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		return gridpane;
	}
	
	public GridPane setupPlayGame(GridPane gridpane, GridPane box, int sCREENBUTTONCOL) {

		Text ballTypes = new Text();
	    ballTypes.setFont(new Font(20));
	    ballTypes.setFill(Color.WHITE);
	    ballTypes.setText("Select Your Game Ball");
	    ballTypes.setStyle("-fx-font: 30 arial;");
	    ballTypes.setTextAlignment(TextAlignment.LEFT);
		GridPane.setHalignment(ballTypes, HPos.LEFT);
		box.add(ballTypes, 0, 1);
		GridPane.setMargin(ballTypes, new Insets(5, 10, 5, 10));	
		
		//ComboBox<String> cbBall = new ComboBox<>();
		cbBall = new ComboBox<>();
	    cbBall.getItems().add("Basketball");
	    cbBall.getItems().add("Bowling Ball");
	    cbBall.getItems().add("Tennis Ball");
	    cbBall.getItems().add("Soccer Ball");
	    box.add(cbBall, 1, 1);
	    
	    GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, sCREENBUTTONCOL, 1);

		return gridpane;
	}
	public ComboBox<String> getCbBall() {
	    return cbBall;
	}
	
	public StackPane tutorialButton(Main app, StackPane rules, Text rulesTitle) {
		this.rulesTitle = rulesTitle;
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
        return rules;
	}
	public Text getRulesTitle() {
		return this.rulesTitle;
	}
}
