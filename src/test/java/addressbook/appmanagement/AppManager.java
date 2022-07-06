package addressbook.appmanagement;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class AppManager {

    NavigationHelper navigationHelper;
    String addressBookUrl = "http://localhost/addressbook/";
    String userName = "admin";
    String password = "secret";

    ChromeDriver driver;
    GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        login(userName, password);
    }

    public void login(String userName, String password) {
        driver.get(addressBookUrl);
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
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
