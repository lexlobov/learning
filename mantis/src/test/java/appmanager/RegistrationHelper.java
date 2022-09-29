package appmanager;

import org.openqa.selenium.WebDriver;

public class RegistrationHelper {


    private final AppManager app;
    private WebDriver driver;

    public RegistrationHelper(AppManager app) {
        this.app = app;
        driver = app.getDriver();
    }

    public void start(String username, String email){
        driver.get(app.getProperty("web.baseUrl") + "/index.php");
    }
}

