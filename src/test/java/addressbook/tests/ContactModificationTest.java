package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTest extends TestBase{

    private final String groupName = "tst 1";
    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException {
        List<ContactData> contacts = app.contact().getListOfContactsFromJsonFile(resourcePath, "modify_contacts.json");
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @BeforeMethod
    private void ensurePreconditions() throws IOException {
        if(! app.contact().isThereAContact()){
            ContactData contact = app.contact().getListOfContactsFromJsonFile(resourcePath, "create_contacts.json").get(0);
            app.goTo().contactPage();
            app.contact().create(contact, groupName);
        }
    }

    @Test(dataProvider = "validContactsJson")
    public void contactModificationTest(ContactData contact) throws IOException {
        ensurePreconditions();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        Groups modifiedContactGroups = modifiedContact.getGroups();
        app.goTo().homePage();
        app.contact().clickCheckboxInList(before.size()-1);
        app.contact().clickEditButtonInTable(modifiedContact.getId());
        app.contact().fillContactForm(contact, false, groupName);
        app.contact().clickUpdateButton();
        app.contact().checkContactUpdated();
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        contact = contact.withId(modifiedContact.getId());


        assertThat("Lists of contacts should be equal", after, equalTo(before.without(modifiedContact).withAdded(contact.withGroups(modifiedContactGroups))));

    }

}
