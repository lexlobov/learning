package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupTest extends TestBase {

    @Test
    public void groupTest(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test", null, null));
    }

}
