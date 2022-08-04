package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;


public class ContactCreateTest extends TestBase {

    private final String groupName = "test";
    @Test
    public void createContactTest(){
        List<ContactData> before = app.contact().list();
        app.goTo().contactPage();
        ContactData contact = new ContactData.Builder()
                .withFirstName("Zohn")
                .withEmail("asdasd@dsf.er")
                .withLastName("Zmith")
                .withMobilePhone("15464654454")
                .withAddress("Southern hemisphere")
                .withGroup(groupName)
                .build();
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();

        List<ContactData> after = app.contact().list();
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c1.getId());
        before.sort(byId);
        after.sort(byId);
        after.get(after.size()-1).setGroup(before.get(before.size()-1).getGroup());
        Assert.assertEquals(before, after);

    }
}
