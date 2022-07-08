package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void deleteContactTest(){
       app.getContactHelper().click(By.xpath("//input[@type='checkbox']"));
       app.getContactHelper().click(By.xpath("//input[@value='Delete']"));
       app.getContactHelper().checkAlertPresent();
       app.getContactHelper().checkMessageCorrect();
    }
}
