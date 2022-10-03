package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppManager {



    private WebDriver driver;
    private final Properties properties;
    private final String  browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftp;

    public AppManager(String   browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }



    public void stop() {
        if(driver !=null) driver.quit();
    }
    public HttpSession newSession(){
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if(registrationHelper == null){
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public WebDriver getDriver() {
        if (driver == null){
            if (browser.equals(Browser.CHROME.browserName())){
                driver = new ChromeDriver();
            } else if (browser.equals(Browser.FIREFOX.browserName())){
                driver = new FirefoxDriver();
            } else {
                driver = new EdgeDriver();
            }
            driver.get(properties.getProperty("web.baseUrl"));
        }
        return driver;

    }

    public FtpHelper ftp(){
        if(ftp == null){
            ftp = new FtpHelper(this);
        }
        return ftp;
    }
}