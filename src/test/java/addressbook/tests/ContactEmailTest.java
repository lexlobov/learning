package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import static addressbook.tests.TestBase.app;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactEmailTest {

    @Test
    public void testEmailFromHomePageEqualToEmailFromForm(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactFromEditForm = app.contact().infoFromEditForm(contact);
        System.out.println(contact.getEmail());
        System.out.println(contactFromEditForm.getEmail());

        assertThat(contact.getEmail(), equalTo(contactFromEditForm.getEmail()));


    }
}
