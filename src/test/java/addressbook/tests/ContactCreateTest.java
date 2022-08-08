package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import addressbook.model.Contacts;


public class ContactCreateTest extends TestBase {

    private final String groupName = "test";
    @Test
    public void createContactTest() throws InterruptedException {
        Contacts before = app.contact().all();
        app.goTo().contactPage();
        ContactData contact = new ContactData()
                .withFirstName("Zohn")
                .withEmail("asdasd@dsf.er")
                .withLastName("Zmith")
                .withMobilePhone("15464654454")
                .withAddress("Southern hemisphere");
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();

        Contacts after = app.contact().all();
        assertThat("Lists of elements should be equal", after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(c->c.getId()).max().getAsInt()))));

    }
}
