package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{

    private final String groupName = "test";

    @Test
    public void contactModificationTest(){
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToNewContactPage();
            app.getContactHelper().createContact(new ContactData.Builder()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withGroup("test"), groupName);
        }
        app.getContactHelper().click(By.xpath("//img[@title='Edit']"));
        app.getContactHelper().fillContactForm(new ContactData.Builder()
                .withMobilePhone("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .build(),
                false,
                groupName);
        app.getContactHelper().clickUpdateButton();
        app.getContactHelper().checkContactUpdated();
    }
}
