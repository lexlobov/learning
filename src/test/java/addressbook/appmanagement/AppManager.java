package addressbook.appmanagement;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class AppManager {
    ChromeDriver driver;
    String addressBookUrl = "http://localhost/addressbook/";
    String userName = "admin";
    String password = "secret";

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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

    public void submitNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    }

    public void createNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
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

    public void goToNewContactPage() {
        driver.findElement(By.xpath("//a[text()='add new']")).click();
    }

    public void checkDeletedSuccessfully() {
        assertEquals("Group has been removed.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }

    public void clickDeleteButton() {
        driver.findElement(By.name("delete")).click();
    }

    public void clickFirstCheckboxInList() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
}