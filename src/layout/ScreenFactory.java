package layout;
import game.GameScene;

public class ScreenFactory {
	public enum ScreenType {
		MAIN_MENU("Main Menu"),
		LOGIN("Login"),
		PLAY_ONLINE("Play Online"),
		PLAY_OFFLINE("Play Offline"),
		IN_GAME("In Game"),
		SETTINGS("Settings"),
		LEADERBOARD("Leaderboard"),
		TUTORIAL("Tutorial");
		
		private String screenName;
		
		ScreenType(String screenName) {
			this.screenName = screenName;
		}
		
		public String getScreenName() {
			return this.screenName;
		}
	};
	
	public Screen newScreen(ScreenType screenType)
	{
		Screen screen;
		switch (screenType) {
		case MAIN_MENU:
			screen =  new MainMenu();
			break;
		case LOGIN:
			screen =  new Login();
			break;
		case PLAY_ONLINE:
			screen = new PlayOnline();
			break;
		case PLAY_OFFLINE:
			screen = new PlayOffline();
			break;
		case SETTINGS:
			screen = new Settings();
			break;
		case IN_GAME:
			screen = new InGame();
			break;
			/*
		case ScreenType.LEADERBOARD.getScreenName():
			return new LeaderBoard();
			break;
		case ScreenType.LEADERBOARD.getScreenName():
			return new Tutorial();
			break;
			*/
		default:
			screen = null;
		}
		return screen;
	}	
}
