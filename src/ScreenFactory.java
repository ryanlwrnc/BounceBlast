import javafx.scene.Scene;

public class ScreenFactory extends Main{
	
	//screenTypes: "Main Menu" | "Login" | "Settings" | etc
	public void newScreen(String screenType)
	{
		Screen screen = null;
		Scene scene = null;
		if(screenType.equals("Main Menu"))
		{
			screen = new MainMenu();
		}
		
		else// if(screenType.equals("Login"))
			screen = new Login();
	/*	else if(screenType.equals("Play Online"))
			scene = PlayOnline.getScene();
		else if(screenType.equals("Play Offline"))
			scene = PlayOffline.getScene();
		else if(screenType.equals("Settings"))
			scene = Settings.getScene();
		else if(screenType.equals("Leaderboard"))
			scene = Leaderboard.getScene();
		else if(screenType.equals("Tutorial"))
			scene = PlayOnline.getScene();
		else if(screenType.equals("Play Online"))
			scene = PlayOnline.getScene();
	*/	
		scene = screen.getScene();
		updateScene(scene);
	}
}
