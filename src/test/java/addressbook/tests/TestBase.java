package addressbook.tests;

import addressbook.appmanagement.AppManager;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static final AppManager app
            = new AppManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
