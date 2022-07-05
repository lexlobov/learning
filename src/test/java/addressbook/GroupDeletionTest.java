package addressbook;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest(){
        goToGroupPage();
        clickFirstCheckboxInList();
        clickDeleteButton();
        checkDeletedSuccessfully();
    }

}
