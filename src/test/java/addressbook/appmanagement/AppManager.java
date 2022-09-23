package addressbook.appmanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppManager {



    WebDriver driver;
    private final Properties properties;
    GroupHelper groupHelper;
    NavigationHelper navigationHelper;
    SessionHelper sessionHelper;
    ContactHelper contactHelper;
    DbHelper dbHelper;
    private final String  browser;

    public AppManager(String   browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper();
        if (browser.equals(Browser.CHROME.browserName())){
            driver = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())){
            driver = new FirefoxDriver();
        } else {
            driver = new EdgeDriver();
        }

        driver.get(properties.getProperty("web.baseUrl"));

        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
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

    public DbHelper db(){
        return dbHelper;
    }
}
