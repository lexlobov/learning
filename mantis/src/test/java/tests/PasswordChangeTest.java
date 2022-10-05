package tests;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PasswordChangeTest extends TestBase{



    @Test
    public void passwordChangeTest() throws InterruptedException {
        String  username = "user1";
        String adminUsername = app.getProperty("web.adminLogin");
        String adminPassword = app.getProperty("web.adminPassword");
        app.login().start(adminUsername, adminPassword);
        app.navigate().toUsersPage();
        assertThat(app.navigate().toTestedUserPage(username), equalTo(true));


    }
}
