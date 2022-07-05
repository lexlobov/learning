package addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver driver;
    String addressBookUrl = "http://localhost/addressbook/";
    String userName = "admin";
    String password = "secret";

    @BeforeMethod
    public void setUp(){
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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    protected void submitNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    }

    protected void createNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    protected void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    protected void submitGroupDeletion() {
        driver.findElement(By.name("delete")).click();
    }

    protected void clickFirstCheckBoxInTheList() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
}
