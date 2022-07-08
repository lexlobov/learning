package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        click(By.xpath("//a[text()='groups']"));
    }

    public void goToNewContactPage() {
        click(By.xpath("//a[text()='add new']"));
    }
}
