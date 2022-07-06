package addressbook.appmanagement;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class GroupHelper {

    ChromeDriver driver;
    public GroupHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    public void submitNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
        driver.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
    }

    public void createNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    public void checkDeletedSuccessfully() {
        assertEquals("Group has been removed.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }

    public void clickDeleteButton() {
        driver.findElement(By.name("delete")).click();
    }

    public void clickFirstCheckboxInList() {
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
}
