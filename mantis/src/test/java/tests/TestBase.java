package tests;

import appmanager.AppManager;
import org.openqa.selenium.remote.Browser;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static final AppManager app
            = new AppManager(System.getProperty("browser", Browser.CHROME.browserName()));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
