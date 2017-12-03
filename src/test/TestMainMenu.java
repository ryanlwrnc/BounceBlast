// Author: Anand Batjargal
package test;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import layout.Main;
import layout.MainMenu;

public class TestMainMenu {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	@Test
	public void testMainMenuLogIn() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(
				"bounceblast-12d9c-firebase-adminsdk-5agr2-4d1fd4fbc0.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://bounceblast-12d9c.firebaseio.com/").build();

		FirebaseApp.initializeApp(options);
		Main main = new Main();
		MainMenu mainMenu = new MainMenu(main);
		mainMenu.logIn("username");
		assertEquals(mainMenu.getUsername(), "username");
	}
}