package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.AssertJUnit.assertEquals;

public class TestBase {

    public final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp(){
        app.init();
    }

    @AfterMethod
    public void tearDown(){
        app.stop();
    }

}
