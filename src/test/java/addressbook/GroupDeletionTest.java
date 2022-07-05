package addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion(){
        goToGroupPage();
        clickFirstCheckBoxInTheList();
        submitGroupDeletion();
        assertEquals("Group has been removed.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }

}
