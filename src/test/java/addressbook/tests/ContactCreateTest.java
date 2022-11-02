package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ContactCreateTest extends TestBase {

    private final String groupName = "tst 1";

    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException {
        List<ContactData> contacts = app.contact().getListOfContactsFromJsonFile(resourcePath, "create_contacts.json");
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsXml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(resourcePath + "contacts.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{ContactData.class}); // Без этой строки ничего не работает. Решение https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        xStream.processAnnotations(GroupData.class);
        List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsCsv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(resourcePath + "contacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withFirstName(split[0])
                    .withLastName(split[1])
                    .withAddress(split[2])
                    .withMobilePhone(split[3])
                    .withHomePhone(split[4])
                    .withWorkPhone(split[5])
                    .withEmail(split[6])
                    .withEmail2(split[7])
                    .withEmail3(split[8])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @Test(dataProvider = "validContactsJson")
    public void createContactTest(ContactData contact) throws InterruptedException {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.goTo().contactPage();
        app.contact().fillContactForm(contact, true, groupName);
        app.contact().uploadPhoto(contact.getPhoto());
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();
        Groups groups = new Groups();
        app.db().groups().stream()
                .filter(g -> g.getId() == app.contact().getGroupId())
                .findFirst()
                .ifPresent(groups::add);
        Contacts after = app.db().contacts();
        int newContactId = after.stream().mapToInt(c -> c.getId()).max().getAsInt();
        ContactData addedContact = contact
                .withId(newContactId)
                .withGroups(groups);


        //Contacts beforeWithAddedContact = before.withAdded(addedContact);

        assertThat("Lists of elements should be equal", after, equalTo(before.withAdded(addedContact)));

    }

}
