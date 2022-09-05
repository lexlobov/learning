package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactPhoneTest  extends TestBase{

    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
