import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
        launch(args);
    	}
	@Override
	public void start(Stage stage) throws Exception{
		Scene scene;
		MainMenu mainMenu = new MainMenu();
		scene = mainMenu.getScene();
		stage.setScene(scene);
		stage.show();
	}
}
