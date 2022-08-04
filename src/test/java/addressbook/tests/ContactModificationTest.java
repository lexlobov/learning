package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

    private final String groupName = "test";

    @BeforeMethod
    private void ensurePreconditions() {
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToNewContactPage();
            app.getContactHelper().createContact(new ContactData.Builder()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withAddress("Hryushkina street")
                    .withGroup("test"), groupName);
        }
    }

    @Test
    public void contactModificationTest(){
        ensurePreconditions();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickCheckboxInList(before.size()-1);
        ContactData contact = new ContactData.Builder()
                .withId(before.get(before.size()-1).getId())
                .withMobilePhone("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .withAddress("Pushkina street")
                .build();
        app.getContactHelper().clickEditButtonInTable(before.size()-1);
        app.getContactHelper().fillContactForm(contact, false, groupName);
        app.getContactHelper().clickUpdateButton();
        app.getContactHelper().checkContactUpdated();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);

    }


}
