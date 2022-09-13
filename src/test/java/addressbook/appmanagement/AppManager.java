package addressbook.appmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
public class AppManager {


    String userName = "admin";
    String password = "secret";

    String addressBookUrl = "http://localhost/addressbook/";

    WebDriver driver;
    GroupHelper groupHelper;
    NavigationHelper navigationHelper;
    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    private String  browser;

    public AppManager(String   browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(Browser.CHROME.browserName())){
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())){
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        System.out.println(Browser.FIREFOX.browserName());

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

    public ContactHelper contact(){
        return contactHelper;
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
