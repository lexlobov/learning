package tests;

import appmanager.HttpSession;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends TestBase{

    @Test
    public void testLogin() throws IOException {
        HttpSession session= app.newSession();
        assertThat(session.login("administrator", "root"), equalTo(true));
        assertThat(session.isLoggedInAs("administrator"), equalTo(true));

    }
}
