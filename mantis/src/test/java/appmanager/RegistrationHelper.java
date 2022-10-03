package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends BaseHelper {

    public RegistrationHelper(AppManager app) {
        super(app);
    }

    public void start(String username, String email) {
        driver.get(app.getProperty("web.baseUrl") + "/index.php");
        click(By.xpath("//a"));
        typeTextIntoField(By.name("username"), username);
        typeTextIntoField(By.name("email"), email);
        click(By.xpath("//input[@type='submit']"));
    }
}

