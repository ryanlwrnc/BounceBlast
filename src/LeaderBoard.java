import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class LeaderBoard extends Application {
 
    private TableView<PlayerName> table;
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void init() {
    		
    		table = new TableView<PlayerName>(); 
    
    		table.getColumns().addAll(PlayerName.getColumn(table));
    		
    		table.setItems(getPlayerDummy());
    }
    @Override
    public void start(Stage stage) {
    		final Label label = new Label("Leader Board");
    		label.setFont(new Font("Arial", 50));
 
        VBox root = new VBox();
        root.getChildren().addAll(table);
 
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    public static ObservableList<PlayerName> getPlayerDummy() {
    		ObservableList<PlayerName> data = FXCollections.observableArrayList();
    		
    		data.addAll(new PlayerName(1, "DFalessi", 30));
    		data.addAll(new PlayerName(2, "Mark", 24));
    		data.addAll(new PlayerName(3, "Ryan", 23));
    		data.addAll(new PlayerName(4, "Anand", 19));




    		
    		
    		return data;
    }
}