package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Set<ContactData> before = app.contact().all();
        ContactData modifiedGroup = before.iterator().next();
        app.contact().clickCheckboxInList(before.size()-1);
        ContactData contact = new ContactData()
                .withId(modifiedGroup.getId())
                .withMobilePhone("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .withAddress("Pushkina street");
        app.contact().clickEditButtonInTable(modifiedGroup.getId());
        app.contact().fillContactForm(contact, false, groupName);
        app.contact().clickUpdateButton();
        app.contact().checkContactUpdated();
        app.goTo().homePage();

        Set<ContactData> after = app.contact().all();
        before.remove(modifiedGroup);
        before.add(contact);
        Assert.assertEquals(after, before);

    }


}
