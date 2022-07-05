package addressbook.tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion(){
        app.goToGroupPage();
        app.clickFirstCheckBoxInTheList();
        app.submitGroupDeletion();
        app.checkGroupDeleted();
    }

}
