package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CreateContactTest extends TestBase {

    private final String groupName = "test";
    @Test
    public void createContactTest(){
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToNewContactPage();
        ContactData contact = new ContactData.Builder()
                .withFirstName("Zohn")
                .withEmail("asdasd@dsf.er")
                .withLastName("Zmith")
                .withMobilePhone("15464654454")
                .withAddress("Southern hemisphere")
                .withGroup(groupName)
                .build();
        app.getContactHelper().fillContactForm(contact, true, groupName);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().checkNewContactAdded();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c1.getId());
        before.sort(byId);
        after.sort(byId);
        after.get(after.size()-1).setGroup(before.get(before.size()-1).getGroup());
        Assert.assertEquals(before, after);

    }
}
