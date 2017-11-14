package layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	static Scene myScene;
	static Stage myStage;
	public static void main(String[] args) {
        launch(args);
    	}
	@Override
	public void start(Stage stage) throws Exception{
		myStage = stage;
		Screen mainMenu = new MainMenu();
		myScene = mainMenu.getScene();
		myStage.setScene(myScene);
		myStage.show();
	}
	
	public void updateScene(Scene s)
	{
		myScene = s;
		myStage.setScene(myScene);
		myStage.show();
	}
}
