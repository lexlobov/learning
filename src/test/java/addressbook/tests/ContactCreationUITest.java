package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationUITest extends TestBase {

    private final String groupName = "tst 1";
    @Test
    public void createContactTest() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.goTo().contactPage();

        ContactData contact = new ContactData()
                .withFirstName("Amy")
                .withLastName("Acker")
                .withAddress("Kolotushkina street 85")
                .withMobilePhone("+79854842258")
                .withWorkPhone("98745558")
                .withHomePhone("85-522-52")
                .withSecondaryAddressHome("656256564")
                .withEmail("amy@email.com")
                .withEmail2("amy@yahoo.com")
                .withEmail3("amy@gmail.com");

        File photo = new File(resourcePath + "js.jpg");
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().uploadPhoto(photo.getAbsolutePath());
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();

        Contacts after = app.contact().all();

        ContactData addedContact = contact
                .withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt())
                .withAllPhones(app.contact().mergePhones(contact))
                .withAllEmails(app.contact().mergeEmails(contact))
                .withMobilePhone(null)
                .withWorkPhone(null)
                .withHomePhone(null)
                .withSecondaryAddressHome(null)
                .withEmail(null)
                .withEmail2(null)
                .withEmail3(null);

        assertThat("Lists of elements should be equal", after, equalTo(before.withAdded(addedContact)));

    }

}
