package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginHelper extends BaseHelper {


    public LoginHelper(AppManager app) {
        super(app);
    }

    public void start(String username, String password){
        driver.get(app.getProperty("web.baseUrl") + "/login_page.php");
        typeTextIntoField(By.name("username"), username);
        click(By.xpath("//input[@type='submit']"));
        typeTextIntoField(By.name("password"), password);
        click(By.xpath("//input[@type='submit']"));
        assertThat("Admin username should be present on the page", isLoggedIn(username), equalTo(true));
    }



    public boolean isLoggedIn(String username){
        List<WebElement> hrefs = driver.findElements(By.xpath("//a[@href='/mantis/account_page.php']"));
        String actualUsername = hrefs.get(1).getText();
        if(actualUsername.equals(username)){
            return true;
        } else return false;
    }
}
