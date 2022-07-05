package addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.AssertJUnit.assertEquals;

public class TestBase extends AppManager {


    @BeforeMethod
    public void setUp(){
        init();
    }

    @AfterMethod
    public void tearDown(){
        stop();
    }

}
