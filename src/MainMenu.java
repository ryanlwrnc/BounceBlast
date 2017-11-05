import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu extends Application{
	Label label1;
	Button button1;
	Button numButton0;
	
	public static void main(String[] args) {
        launch(args);
    }
	 @Override
    public void start(Stage stage) throws Exception{
		 GridPane gridpane = new GridPane();
		 Image img = new Image("file:background.jpg");
		 BackgroundImage bgImg = new BackgroundImage(img, 
		     BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		     BackgroundPosition.DEFAULT, 
		     new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

		 // put stuff in root as normal....
		 
		gridpane.getChildren().add(new ImageView(img));
		Scene scene = new Scene(gridpane);
    		/*stage.setTitle("Calculator");
    		
    		GridPane grid = new GridPane();
    		grid.setAlignment(Pos.CENTER);
    		grid.setHgap(9);
    		grid.setVgap(9);
    		grid.setPadding(new Insets(25, 25, 25, 25));
    		
    		TextField tf = new TextField();
    		tf.setDisable(true);
    		tf.setMaxWidth(135);
    		tf.setText(displayNum);
    		tf.setAlignment(Pos.BASELINE_RIGHT);
    		grid.add(tf, 0, 0, 4, 1);
    		
    		Button numButtons[] = new Button[] {numButton0, numButton1, numButton2, numButton3,
    				numButton4, numButton5, numButton6, numButton7, 
    				numButton8, numButton9};   
    		
    		numButtons[0] = new Button("0");
    		grid.add(numButtons[0], 0, 4);
    		numButtons[0].setOnAction(new EventHandler<ActionEvent>() {
    			public void handle(ActionEvent event) {
    				lastClickedIsNum = 1;
    				if (displayNum.equals("0"))
    					displayNum = String.valueOf(0);
    				else
    					displayNum = displayNum.substring(0, displayNum.length()) + String.valueOf(0);
    				tf.setText(displayNum);
    			}
    		});
    	
    		*/
    		//Scene scene = new Scene(grid, 300, 300);
    		stage.setScene(scene);
        stage.show();
    }
}
