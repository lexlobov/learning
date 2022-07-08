package addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

    @Test
    public void contactModificationTest(){
        app.getContactHelper().click(By.xpath("//img[@title='Edit']"));

    }
}
