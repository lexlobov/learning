package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionUITest extends TestBase{

    private final String groupName = "tst 1";

    @BeforeMethod
    private void ensurePreconditions() throws InterruptedException {
        if(app.contact().list().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru"), groupName);
            app.goTo().homePage();
        }
    }

    @Test
    public void deleteContactTest() throws InterruptedException {
        ensurePreconditions();
        Contacts before =  app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact.getId());
        app.contact().checkAlertPresent();
        app.contact().checkMessageCorrect();
        app.goTo().homePage();
        Contacts after = app.contact().all();
        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
