package addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest(){
        app.goToGroupPage();
        app.getGroupHelper().clickFirstCheckboxInList();
        app.getGroupHelper().clickDeleteButton();
        app.getGroupHelper().checkDeletedSuccessfully();
    }

}
