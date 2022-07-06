package addressbook.appmanagement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {

    ChromeDriver driver;
    public NavigationHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void goToNewContactPage() {
        driver.findElement(By.xpath("//a[text()='add new']")).click();
    }
}
