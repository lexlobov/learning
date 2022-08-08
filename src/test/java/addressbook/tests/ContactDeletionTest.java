package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactDeletionTest extends TestBase{

    private final String groupName = "test";

    @BeforeMethod
    private void ensurePreconditions() throws InterruptedException {
        if(app.contact().list().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withGroup("test"), groupName);
            app.contact().click(By.xpath("//a[text()='home page']"));
        }
    }

    @Test
    public void deleteContactTest() throws InterruptedException {
        ensurePreconditions();
        Set<ContactData> before =  app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact.getId());
        app.contact().click(By.xpath("//input[@value='Delete']"));
        app.contact().checkAlertPresent();
        app.contact().checkMessageCorrect();
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }


}
