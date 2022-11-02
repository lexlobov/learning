package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class ContactDeletionTest extends TestBase{

    private final String groupName = "tst 1";

    @BeforeMethod
    private void ensurePreconditions() throws InterruptedException, IOException {
        if(app.contact().list().size() == 0){
            ContactData contact = app.contact().getListOfContactsFromJsonFile(resourcePath, "create_contacts.json").get(0);
            app.goTo().contactPage();
            app.contact().create(contact, groupName);
            app.goTo().homePage();
        }
    }

    @Test
    public void deleteContactTest() throws InterruptedException, IOException {
        ensurePreconditions();
        Contacts before =  app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact.getId());
        app.contact().checkAlertPresent();
        app.contact().checkMessageCorrect();
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        before.remove(deletedContact);
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}
