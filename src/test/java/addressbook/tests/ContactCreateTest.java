package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import addressbook.model.Contacts;

import java.io.File;


public class ContactCreateTest extends TestBase {

    private final String groupName = "test";
    @Test
    public void createContactTest() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        System.out.println(before);
        app.goTo().contactPage();
        File photo = new File("src/test/resources/js.jpg");
        ContactData contact = new ContactData()
                .withFirstName("Zohn")
                .withEmail("asdasd@dsf.er")
                .withLastName("Zmith")
                .withAllPhones("15464654454")
                .withAddress("Southern hemisphere")
                .withPhoto(photo);
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();

        Contacts after = app.contact().all();
        System.out.println(after);
        assertThat("Lists of elements should be equal", after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(c->c.getId()).max().getAsInt()))));

    }

//    @Test
//    public void testCurrentDir(){
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/js.jpg");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }
}
