package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;


public class CreateContactTest extends TestBase {

    @Test
    public void createContactTest(){
        app.getNavigationHelper().goToNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData.Builder()
                .withFirstName("John")
                .withEmail2("asdasd@dsf.er")
                .withLastName("Smith")
                .withMobilePhone("15464654454")
                .withGroup("test1g")
                .build(), true);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().checkNewContactAdded();

    }
}
