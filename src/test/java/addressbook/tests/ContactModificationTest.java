package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactModificationTest extends TestBase{

    private final String groupName = "tst 1";

    @BeforeMethod
    private void ensurePreconditions() {
        if(! app.contact().isThereAContact()){
            app.goTo().contactPage();
            app.contact().create(new ContactData()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withAddress("Hryushkina street")
                    .withHomePhone("464984984")
                    .withWorkPhone("656654654654")
                    .withMobilePhone("5984894984984898944")
                    .withEmail2("kgdfjgk@fkgjf.tu")
                    .withEmail3("dsfdf@mbm.rt"), groupName);
        }
    }

    @Test
    public void contactModificationTest() throws IOException {
        ensurePreconditions();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        Groups modifiedContactGroups = modifiedContact.getGroups();
        app.contact().clickCheckboxInList(before.size()-1);
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withMobilePhone("5550173")
                .withFirstName("Elvis")
                .withLastName("Prado")
                .withEmail("Elvis@maik.ru")
                .withEmail2("Elvis2@maik.ru")
                .withEmail3("Elvis3@maik.ru")
                .withAddress("Pushkina street")
                .withWorkPhone("48484848484")
                .withHomePhone("8878787")
                .withAddress("powepeopwwepro");

        app.contact().clickEditButtonInTable(modifiedContact.getId());
        app.contact().fillContactForm(contact, false, groupName);
        app.contact().clickUpdateButton();
        app.contact().checkContactUpdated();
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        contact = contact.withId(modifiedContact.getId());


        assertThat("", after, equalTo(before.without(modifiedContact).withAdded(contact.withGroups(modifiedContactGroups))));

    }



    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter(s -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter(s -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
