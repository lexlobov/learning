package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.linkText("new"))){
            return;
        }else {
            click(By.xpath("//a[text()='groups']"));
        }

    }

    public void homePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }else {
            click(By.xpath("//a[text()='home']"));
        }
    }

    public void contactPage(){
        click(By.xpath("//a[text()='add new']"));
    }
}
