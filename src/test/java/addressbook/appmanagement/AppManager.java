package addressbook.appmanagement;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class AppManager {


    String userName = "admin";
    String password = "secret";

    ChromeDriver driver;
    GroupHelper groupHelper;
    NavigationHelper navigationHelper;
    SessionHelper sessionHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login(userName, password);
    }



    public void stop() {
        driver.quit();
    }

    public void checkNewContactAdded() {
        assertEquals("Information entered into address book.\nadd next or return to home page.", driver.findElement(By.className("msgbox")).getText());
    }

    public void submitNewContact() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void fillNewContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        driver.findElement(By.name("mobile")).sendKeys(contactData.getPhoneNumber());
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
