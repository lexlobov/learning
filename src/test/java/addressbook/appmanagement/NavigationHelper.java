package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends BaseHelper {

    ChromeDriver driver;
    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        click(By.xpath("//a[text()='groups']"));
    }

    public void goToNewContactPage() {
        click(By.xpath("//a[text()='add new']"));
    }
}
