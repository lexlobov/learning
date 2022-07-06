package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {
    ChromeDriver driver;
    String addressBookUrl = "http://localhost/addressbook/";


    public SessionHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        driver.get(addressBookUrl);
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
