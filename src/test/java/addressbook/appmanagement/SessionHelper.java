package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends BaseHelper {
    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        typeTextIntoField(By.name("user"), userName);
        typeTextIntoField(By.name("pass"), password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
