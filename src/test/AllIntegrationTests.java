package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllIntegrationTestsAnand.class, AllIntegrationTestsElliot.class, AllIntegrationTestsMark.class,
		AllIntegrationTestsRey.class, AllIntegrationTestsRyan.class, AllIntegrationTestsWon.class })
public class AllIntegrationTests {

}
