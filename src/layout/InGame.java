package layout;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class InGame extends Scene {
	// JavaFX
	private GridPane gridpane;
	
	// Components
	private BackToMainMenuButton quitGame;
	private Text gameTitle;
	private Rectangle namesRect;
	private GridPane nameGrid;
	private RowConstraints rcons1;
	private RowConstraints rcons2;
	static final String FONT16 = "-fx-font: 16 arial;";
	
	public InGame(Main app) {
		super(new GridPane(), 800, 600);
		this.gridpane =  (GridPane) getRoot();
		
		int screenButtonCol = 2;
		
		// Gridpane
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		
		// BounceBlast text
		gameTitle = new Text();
		gameTitle.setFont(new Font(20));
		gameTitle.setFill(Color.WHITE);
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		// Names Gridpane
		namesRect = new Rectangle();
		namesRect.setWidth(160);
		namesRect.setHeight(115);
		namesRect.setFill(Color.WHITE);
		namesRect.setOpacity(.3);
		gridpane.add(namesRect, 0,0);
		GridPane.setMargin(namesRect, new Insets(10,0,0,50));
		
		nameGrid = new GridPane();
		ColumnConstraints cons3 = new ColumnConstraints();
		cons3.setHgrow(Priority.NEVER);
        nameGrid.getColumnConstraints().add(cons3);

        ColumnConstraints cons4 = new ColumnConstraints();
        cons4.setHgrow(Priority.NEVER);
        
        nameGrid.getColumnConstraints().addAll(cons3, cons4);
        
        RowConstraints rcons3 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons4 = new RowConstraints();
        rcons2.setVgrow(Priority.NEVER);  
        
        nameGrid.getRowConstraints().addAll(rcons3, rcons4);
        nameGrid.setAlignment(Pos.TOP_CENTER);
        nameGrid.setVgap(0);
        gridpane.add(nameGrid, 0, 0);
        GridPane.setMargin(nameGrid, new Insets(10, 0, 0, 0));
		
		// Start of Names
		Text name0 = new Text();
		name0.setFont(new Font(20));
		name0.setFill(Color.WHITE);
		name0.setText("DFalessi");
		name0.setStyle(FONT16);
		name0.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name0, HPos.LEFT);
		nameGrid.add(name0, 0, 0);
		GridPane.setMargin(name0, new Insets(5, 10, 5, 50));
	
		Text name1 = new Text();
		name1.setFont(new Font(20));
		name1.setFill(Color.WHITE);
		name1.setText("meatwadsprite");
		name1.setStyle(FONT16);
		name1.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name1, HPos.LEFT);
		nameGrid.add(name1, 0, 1);
		GridPane.setMargin(name1, new Insets(5, 10, 5, 50));
		
		Text name2 = new Text();
		name2.setFont(new Font(20));
		name2.setFill(Color.WHITE);
		name2.setText("liftlift");
		name2.setStyle(FONT16);
		name2.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name2, HPos.LEFT);
		nameGrid.add(name2, 0, 2);
		GridPane.setMargin(name2, new Insets(5, 10, 5, 50));
		
		Text name3 = new Text();
		name3.setFont(new Font(20));
		name3.setFill(Color.WHITE);
		name3.setText("pooksieboo");
		name3.setStyle(FONT16);
		name3.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name3, HPos.LEFT);
		nameGrid.add(name3, 0, 3);
		GridPane.setMargin(name3, new Insets(5, 10, 5, 50));
		// End of Names
		
		// scores
		Text score0 = new Text();
		score0.setFont(new Font(20));
		score0.setFill(Color.WHITE);
		score0.setText("7");
		score0.setStyle(FONT16);
		score0.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score0, HPos.RIGHT);
		nameGrid.add(score0, 3, 0);
		GridPane.setMargin(score0, new Insets(5, 10, 5, 10));
		
		Text score1 = new Text();
		score1.setFont(new Font(20));
		score1.setFill(Color.WHITE);
		score1.setText("5");
		score1.setStyle(FONT16);
		score1.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score1, HPos.RIGHT);
		nameGrid.add(score1, 3, 1);
		GridPane.setMargin(score1, new Insets(5, 10, 5, 10));
		
		Text score2 = new Text();
		score2.setFont(new Font(20));
		score2.setFill(Color.WHITE);
		score2.setText("2");
		score2.setStyle(FONT16);
		score2.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score2, HPos.RIGHT);
		nameGrid.add(score2, 3, 2);
		GridPane.setMargin(score2, new Insets(5, 10, 5, 10));
		
		Text score3 = new Text();
		score3.setFont(new Font(20));
		score3.setFill(Color.WHITE);
		score3.setText("0");
		score3.setStyle(FONT16);
		score3.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score3, HPos.RIGHT);
		nameGrid.add(score3, 3, 3);
		GridPane.setMargin(score3, new Insets(5, 10, 5, 10));
		
		Rectangle roundRect = new Rectangle();
		roundRect.setWidth(70);
		roundRect.setHeight(24);
		roundRect.setFill(Color.WHITE);
		roundRect.setOpacity(.3);
		gridpane.add(roundRect, 3,0);
		GridPane.setMargin(roundRect, new Insets(5,50,5,0));
		
		Text round = new Text();
		round.setFont(new Font(20));
		round.setFill(Color.WHITE);
		round.setText("Round: 1");
		round.setStyle(FONT16);
		round.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(round, HPos.CENTER);
		gridpane.add(round, 3, 0);
		GridPane.setMargin(round, new Insets(5, 50, 5, 0));
		
		Ellipse ellipse = new Ellipse();
		ellipse.setRadiusX(275);
		ellipse.setRadiusY(180);
		ellipse.setFill(Color.GREEN);
		gridpane.add(ellipse, 2, 3);
		GridPane.setMargin(ellipse,  new Insets(50, 5, 10, 5));
		
		// Quit Button - When pressed, goes back to the main menu.
		quitGame = new BackToMainMenuButton(app, "Quit");
		gridpane.add(quitGame, 0, 10);
		GridPane.setHalignment(quitGame, HPos.CENTER);
		GridPane.setMargin(quitGame, new Insets(5, 45, 5, 10));
	}
	public BackToMainMenuButton getBackButton() {
		return this.quitGame;
	}
}
