package tests;

import Model.MailMessage;
import Model.User;
import Model.Users;
import appmanager.HttpSession;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static tests.RegistrationTest.findConfirmationLink;

public class PasswordChangeTest extends TestBase{


    String newPassword = "1234554321FF";

    @BeforeMethod(alwaysRun = true)
    public void startMailServer(){
        app.mail().start();
    }

    @AfterMethod
    public void stopMailServer(){
        app.mail().stop();
    }

    @Test
    public void passwordChangeTest() throws InterruptedException, MessagingException, IOException {

        String adminUsername = app.getProperty("web.adminLogin");
        String adminPassword = app.getProperty("web.adminPassword");


        Users users = app.db().usersSet();
        User user1 = users.stream()
                .filter(this::nonAdmin)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No users for testing"));

        List<User> dbUsers = app.db().users();
        User user = dbUsers.stream()
                .filter(this::nonAdmin)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No users for testing"));


        app.login().start(adminUsername, adminPassword);
        app.navigate().toUsersPage();
        assertThat(app.navigate().toTestedUserPage(user1.getUsername()), equalTo(true));
        app.navigate().clickResetUserPasswordButton();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000l);
        String confirmationLink = findConfirmationLink(mailMessages, user1.getEmail());
        System.out.println(confirmationLink);
        app.registration().finish(confirmationLink, newPassword);
        HttpSession session= app.newSession();
        assertThat(session.login(user1.getUsername(), newPassword), equalTo(true));
        //assertThat(session.isLoggedInAs(user.getUsername()), equalTo(true));

    }

    private boolean nonAdmin(User user) {
        return !Objects.equals(user.getUsername(), app.getProperty("web.adminLogin"));
    }
}
