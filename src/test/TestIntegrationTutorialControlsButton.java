// Author: Elliot Kirk
package test;

import static org.junit.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javafx.stage.Stage;
import layout.Main;
import layout.TutorialControls;
import layout.components.BackToMainMenuButton;

public class TestIntegrationTutorialControlsButton {
	@Rule
	public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
	
	@Test
	public void testBackButton() throws IOException{
		Main main = new Main();
		main.setStage(new Stage());
		TutorialControls tutorialControls = new TutorialControls(main);
		BackToMainMenuButton back = tutorialControls.getBackButton();
		FileInputStream serviceAccount = new FileInputStream(
				"bounceblast-12d9c-firebase-adminsdk-5agr2-4d1fd4fbc0.json");
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://bounceblast-12d9c.firebaseio.com/").build();

		FirebaseApp.initializeApp(options);
		back.fire();
		assertEquals(back.getBeenClicked(), true);
	}
}
