package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupTest extends TestBase {

    @Test
    public void groupTest(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createNewGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitNewGroup();
    }

}
