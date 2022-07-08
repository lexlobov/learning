package addressbook.appmanagement;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertEquals;

public class GroupHelper extends BaseHelper {

    public GroupHelper(ChromeDriver driver) {
        super(driver);
    }

    public void submitNewGroup() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        typeTextIntoField(By.name("group_name"), groupData.getGroupName());
        typeTextIntoField(By.name("group_header"), groupData.getGroupHeader());
        typeTextIntoField(By.name("group_footer"), groupData.getGroupFooter());
    }

    public void createNewGroup() {
        click(By.name("new"));
    }

    public void checkDeletedSuccessfully() {
        assertEquals("Group has been removed.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }

    public void clickDeleteButton() {
        click(By.name("delete"));
    }

    public void clickFirstCheckboxInList() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void checkIfGroupUpdated(){
        assertEquals("Group record has been updated.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }
}
