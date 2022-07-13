package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

    @Test
    public void contactModificationTest(){
        app.getContactHelper().click(By.xpath("//img[@title='Edit']"));
        app.getContactHelper().fillNewContactForm(new ContactData.Builder()
                .withMobilePhone("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .build());
        app.getContactHelper().clickUpdateButton();
        app.getContactHelper().checkContactUpdated();
    }
}
