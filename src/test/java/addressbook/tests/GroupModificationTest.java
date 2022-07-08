package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().clickFirstCheckboxInList();
        app.getGroupHelper().click(By.name("edit"));
        app.getGroupHelper().typeTextIntoField(By.name("group_name"), "updated group");
        app.getGroupHelper().typeTextIntoField(By.name("group_header"), "updated group header");
        app.getGroupHelper().click(By.name("update"));
        app.getGroupHelper().checkIfGroupUpdated();

    }
}
