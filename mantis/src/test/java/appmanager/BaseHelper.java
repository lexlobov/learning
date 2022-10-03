package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class BaseHelper {
    WebDriver driver;
    protected AppManager app;

    public BaseHelper(AppManager app){
        this.app = app;
        this.driver = app.getDriver();
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

    public void attach(By locator, File file){
        if (file != null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
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