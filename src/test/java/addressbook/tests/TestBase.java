package addressbook.tests;

import addressbook.appmanagement.AppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public final AppManager app = new AppManager(Browser.CHROME);

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }

}
