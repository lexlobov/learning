package addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class GroupDeletionTest extends TestBase {

    @Test
    public void groupDeletionTest(){
        goToGroupPage();
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.name("delete")).click();
        assertEquals("Group has been removed.\nreturn to the group page", driver.findElement(By.className("msgbox")).getText());
    }
}
