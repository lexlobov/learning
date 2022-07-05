package addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.AssertJUnit.assertEquals;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeMethod
    public void setUp(){
        applicationManager.app.init();
    }

    @AfterMethod
    public void tearDown(){
        applicationManager.app.stop();
    }

}
