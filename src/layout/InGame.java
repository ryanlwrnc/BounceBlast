package layout;
import java.awt.Label;
import java.awt.TextField;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class InGame  extends Main implements Screen{
	public Scene getScene() {
		Button  exit;
		int screenButtonCol = 2;
		String buttonStyle = "-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 24;" + 
				"-fx-text-fill: white;";
		String buttonHoverStyle = "-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #003399;" +
				"-fx-font-size: 24;" + 
				"-fx-text-fill: white;";
		
		
		  
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
		gameTitle.setText("BounceBlast");
		gameTitle.setStyle("-fx-font: 75 arial;");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(gameTitle, HPos.CENTER);
		gridpane.add(gameTitle, screenButtonCol, 0);
		GridPane.setMargin(gameTitle, new Insets(5, 10, 5, 10));
		
		
		
		// Names Gridpane
		Rectangle namesRect = new Rectangle();
		namesRect.setWidth(160);
		namesRect.setHeight(115);
		namesRect.setFill(Color.WHITE);
		namesRect.setOpacity(.3);
		gridpane.add(namesRect, 0,0);
		GridPane.setMargin(namesRect, new Insets(10,0,0,50));
		
		GridPane nameGrid = new GridPane();
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
		
		//names
		Text name0 = new Text();
		name0.setFont(new Font(20));
		name0.setFill(Color.WHITE);
		name0.setText("DFalessi");
		name0.setStyle("-fx-font: 16 arial;");
		name0.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name0, HPos.LEFT);
		nameGrid.add(name0, 0, 0);
		GridPane.setMargin(name0, new Insets(5, 10, 5, 50));
		

		
		Text name1 = new Text();
		name1.setFont(new Font(20));
		name1.setFill(Color.WHITE);
		name1.setText("meatwadsprite");
		name1.setStyle("-fx-font: 16 arial;");
		name1.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name1, HPos.LEFT);
		nameGrid.add(name1, 0, 1);
		GridPane.setMargin(name1, new Insets(5, 10, 5, 50));
		
		Text name2 = new Text();
		name2.setFont(new Font(20));
		name2.setFill(Color.WHITE);
		name2.setText("liftlift");
		name2.setStyle("-fx-font: 16 arial;");
		name2.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name2, HPos.LEFT);
		nameGrid.add(name2, 0, 2);
		GridPane.setMargin(name2, new Insets(5, 10, 5, 50));
		
		Text name3 = new Text();
		name3.setFont(new Font(20));
		name3.setFill(Color.WHITE);
		name3.setText("pooksieboo");
		name3.setStyle("-fx-font: 16 arial;");
		name3.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(name3, HPos.LEFT);
		nameGrid.add(name3, 0, 3);
		GridPane.setMargin(name3, new Insets(5, 10, 5, 50));
		
		// scores
		Text score0 = new Text();
		score0.setFont(new Font(20));
		score0.setFill(Color.WHITE);
		score0.setText("7");
		score0.setStyle("-fx-font: 16 arial;");
		score0.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score0, HPos.RIGHT);
		nameGrid.add(score0, 3, 0);
		GridPane.setMargin(score0, new Insets(5, 10, 5, 10));
		
		Text score1 = new Text();
		score1.setFont(new Font(20));
		score1.setFill(Color.WHITE);
		score1.setText("5");
		score1.setStyle("-fx-font: 16 arial;");
		score1.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score1, HPos.RIGHT);
		nameGrid.add(score1, 3, 1);
		GridPane.setMargin(score1, new Insets(5, 10, 5, 10));
		
		Text score2 = new Text();
		score2.setFont(new Font(20));
		score2.setFill(Color.WHITE);
		score2.setText("2");
		score2.setStyle("-fx-font: 16 arial;");
		score2.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(score2, HPos.RIGHT);
		nameGrid.add(score2, 3, 2);
		GridPane.setMargin(score2, new Insets(5, 10, 5, 10));
		
		
		
		Text score3 = new Text();
		score3.setFont(new Font(20));
		score3.setFill(Color.WHITE);
		score3.setText("0");
		score3.setStyle("-fx-font: 16 arial;");
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
		round.setStyle("-fx-font: 16 arial;");
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
		
		
		// Exit button
		exit = new Button("Exit");
		exit.setPrefHeight(25);
		exit.setPrefWidth(60);
		exit.setStyle("-fx-border-width: 3;" + 
				"-fx-border-color: white;" + 
				"-fx-background-color: #24618F;" +
				"-fx-font-size: 16;" + 
				"-fx-text-fill: white;");
		gridpane.add(exit, 0, 10);
		GridPane.setHalignment(exit, HPos.CENTER);
		GridPane.setMargin(exit, new Insets(5, 10, 5, 10));
		// Exit the application when exit pressed
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		exit.setStyle("-fx-border-width: 3;" + 
	        				"-fx-border-color: white;" + 
	        				"-fx-background-color: #003399;" +
	        				"-fx-font-size: 16;" + 
	        				"-fx-text-fill: white;");
	        }
	    });

		exit.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	        		exit.setStyle("-fx-border-width: 3;" + 
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
