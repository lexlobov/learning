package addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupTest {

    ChromeDriver driver;
    String addressBookUrl = "http://localhost/addressbook/";
    String userName = "admin";
    String password = "secret";

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(addressBookUrl);
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void groupTest(){
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys("test1");
        driver.findElement(By.name("group_header")).sendKeys("test2");
        driver.findElement(By.name("group_footer")).sendKeys("test3");
        driver.findElement(By.name("submit")).click();
    }
}
