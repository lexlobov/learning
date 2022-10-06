package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NavigationHelper extends BaseHelper{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

    public NavigationHelper(AppManager app) {
        super(app);
    }

    public void toUsersPage() {
        if(app.isAlbumOrientation() == false){
            click(By.id("menu-toggler"));
        }

        WebElement element = driver.findElement(By.xpath("//a[@href='/mantis/manage_overview_page.php']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        click(By.xpath("//a[@href='/mantis/manage_overview_page.php']"));
        click(By.xpath("//a[@href='/mantis/manage_user_page.php']"));
        assertThat("Users table header should be present", driver.findElement(By.tagName("h4")).isDisplayed(), equalTo(true));
    }


    public boolean toTestedUserPage(String username) {
        List<WebElement> userTableRows = driver.findElements(By.xpath("//tbody/tr"));
        for (WebElement element : userTableRows){
            String tableUserName = element.findElements(By.tagName("td")).get(0).getText();
            if(tableUserName.equals(username)){
                element.findElement(By.tagName("a")).click();
                return true;
            }
        }
        return false;
    }

    public void clickResetUserPasswordButton(){
        List<WebElement> submitButtons = driver.findElements(By.xpath("//input[@type='submit']"));
        submitButtons.get(1).click();
    }
}
