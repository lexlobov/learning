package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactEmailTest extends TestBase{

    @Test
    public void testEmailFromHomePageEqualToEmailFromForm() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(app.contact().mergeEmails(contactFromEditForm)));
    }
}
