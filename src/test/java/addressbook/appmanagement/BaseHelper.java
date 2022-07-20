package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver){
        this.driver=driver;
    }

    public void typeTextIntoField(By locator, String text){
        if (text != null){
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public boolean clickAlert(){
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try{
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
