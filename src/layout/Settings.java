package layout;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import layout.components.BackToMainMenuButton;

public class Settings extends Scene{

	// JavaFX
	private GridPane gridpane;
	
	// Components
	BackToMainMenuButton back;
	Text gameTitle;
	Text sound;
	Text directionKeys;
	GridPane box;
	ColumnConstraints cons1;
	ColumnConstraints cons2;
	RowConstraints rcons1;
	RowConstraints rcons2;
	Slider soundSlider;
	ComboBox<String> cbDirection;
	
	// Constants
	private static final int SCREENBUTTONCOL = 2;
	
	
	public Settings(Main app) {
		super(new GridPane(), 800, 600);
		gridpane = (GridPane) getRoot();
		
		ScreenHelper screenHelper = new ScreenHelper();
		gridpane = screenHelper.setupGridpane(gridpane);
		
		rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
		
		cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        
        rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  

        cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
		 
		// BounceBlast text
        GridPane[] gridpanes = screenHelper.titleAndBox(gridpane, rcons1, rcons2,
    			cons1, cons2, SCREENBUTTONCOL, "Settings");
        gridpane = gridpanes[0];
        box = gridpanes[1];
        sound = new Text();
        sound.setFont(new Font(20));
        sound.setFill(Color.WHITE);
        sound.setText("Sound");
        sound.setStyle("-fx-font: 30 arial;");
        sound.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(sound, HPos.RIGHT);
		box.add(sound, 0, 0);
		GridPane.setMargin(sound, new Insets(5, 10, 5, 10));	

		 
		soundSlider = new Slider(0, 1, 0.5);
		box.add(soundSlider, 1, 0);
	
		directionKeys = new Text();
		directionKeys.setFont(new Font(20));
		directionKeys.setFill(Color.WHITE);
		directionKeys.setText("Direction Keys");
		directionKeys.setStyle("-fx-font: 30 arial;");
		directionKeys.setTextAlignment(TextAlignment.RIGHT);
		GridPane.setHalignment(directionKeys, HPos.RIGHT);
		box.add(directionKeys, 0, 1);
		GridPane.setMargin(directionKeys, new Insets(5, 10, 5, 10));	
		
		cbDirection = new ComboBox<>();
        cbDirection.getItems().add("Arrow Keys");
        cbDirection.getItems().add("WASD");
	    box.add(cbDirection, 1, 1);
	    
	    GridPane.setHalignment(box, HPos.CENTER);
		gridpane.add(box, SCREENBUTTONCOL, 1);

		// Back button
		back = new BackToMainMenuButton(app, "Back");
		gridpane.add(back, 0, 10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setMargin(back, new Insets(5, 10, 5, 10));
	}
	public BackToMainMenuButton getBackButton() {
		return this.back;
	}
}
