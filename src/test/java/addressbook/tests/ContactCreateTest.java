package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class ContactCreateTest extends TestBase {

    private final String groupName = "test";
    @Test
    public void createContactTest(){
        Set<ContactData> before = app.contact().all();
        app.goTo().contactPage();
        ContactData contact = new ContactData()
                .withFirstName("Zohn")
                .withEmail("asdasd@dsf.er")
                .withLastName("Zmith")
                .withMobilePhone("15464654454")
                .withAddress("Southern hemisphere")
                .withGroup(groupName);
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();

        Set<ContactData> after = app.contact().all();
        before.add(contact);
        Assert.assertEquals(before, after);

    }
}
