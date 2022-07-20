package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.linkText("new"))){
            return;
        }else {
            click(By.xpath("//a[text()='groups']"));
        }

    }

    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }else {
            click(By.xpath("//a[text()='home']"));
        }
    }

    public void goToNewContactPage(){
        click(By.xpath("//a[text()='add new']"));
    }
}
