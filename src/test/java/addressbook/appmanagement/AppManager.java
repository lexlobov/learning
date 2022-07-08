package addressbook.appmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

public class AppManager {


    String userName = "admin";
    String password = "secret";

    String addressBookUrl = "http://localhost/addressbook/";

    WebDriver driver;
    GroupHelper groupHelper;
    NavigationHelper navigationHelper;
    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    private Browser browser;

    public AppManager(Browser browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser == Browser.CHROME){
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser == Browser.FIREFOX){
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(addressBookUrl);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login(userName, password);
    }



    public void stop() {
        driver.quit();
    }

    public ContactHelper getContactHelper(){
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
