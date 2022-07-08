package addressbook.appmanagement;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {


    String userName = "admin";
    String password = "secret";

    String addressBookUrl = "http://localhost/addressbook/";

    ChromeDriver driver;
    GroupHelper groupHelper;
    NavigationHelper navigationHelper;
    SessionHelper sessionHelper;
    ContactHelper contactHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
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
