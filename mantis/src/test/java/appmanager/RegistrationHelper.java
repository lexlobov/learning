package appmanager;

import org.openqa.selenium.By;

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

    public void finish(String confirmationLink, String password) {
        driver.get(confirmationLink);
        typeTextIntoField(By.name("password"), password);
        typeTextIntoField(By.name("password_confirm"), password);
        typeTextIntoField(By.id("realname"), "John");
        click(By.xpath("//button[@type='submit']"));
    }
}

