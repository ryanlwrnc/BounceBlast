// Author: Won Young Son
package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCreateAccount.class, TestLogin.class, TestProfile.class, TestUser.class })
public class AllUserProfileTests {

}
