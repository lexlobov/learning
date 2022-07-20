package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().clickFirstCheckboxInList();
        app.getGroupHelper().clickDeleteButton();
        app.getGroupHelper().checkDeletedSuccessfully();
    }

}
