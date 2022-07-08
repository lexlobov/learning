package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver){
        this.driver=driver;
    }

    public void typeTextIntoField(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
}
