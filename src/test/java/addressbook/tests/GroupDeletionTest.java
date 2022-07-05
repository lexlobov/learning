package addressbook.tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion(){
        applicationManager.app.goToGroupPage();
        applicationManager.app.clickFirstCheckBoxInTheList();
        applicationManager.app.submitGroupDeletion();
        applicationManager.checkGroupDeleted();
    }

}
