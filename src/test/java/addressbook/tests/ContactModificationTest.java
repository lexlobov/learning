package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTest extends TestBase{

    private final String groupName = "test";

    @BeforeMethod
    private void ensurePreconditions() throws InterruptedException {
        if(! app.contact().isThereAContact()){
            app.goTo().contactPage();
            app.contact().create(new ContactData()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withAddress("Hryushkina street")
                    .withGroup("test"), groupName);
        }
    }

    @Test
    public void contactModificationTest() throws InterruptedException {
        ensurePreconditions();
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        app.contact().clickCheckboxInList(before.size()-1);
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withAllPhones("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .withAddress("Pushkina street");
        app.contact().clickEditButtonInTable(modifiedContact.getId());
        app.contact().fillContactForm(contact, false, groupName);
        app.contact().clickUpdateButton();
        app.contact().checkContactUpdated();
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertThat("", after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
