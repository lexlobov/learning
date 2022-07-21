package addressbook.tests;

import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase{

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().clickCheckboxInList(1);
        app.getGroupHelper().click(By.name("edit"));
        app.getGroupHelper().typeTextIntoField(By.name("group_name"), "updated group");
        app.getGroupHelper().typeTextIntoField(By.name("group_header"), "updated group header");
        app.getGroupHelper().click(By.name("update"));
        app.getGroupHelper().checkIfGroupUpdated();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);

    }
}
