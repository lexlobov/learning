package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class ContactCreateTest extends TestBase {

    private final String groupName = "test";
    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"));
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = (List<ContactData>) gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsXml() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {ContactData.class}); // Без этой строки ничего не работает. Решение https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        xStream.processAnnotations(GroupData.class);
        List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validContactsCsv() throws IOException{
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[] {new ContactData()
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
        File photo = new File("src/test/resources/js.jpg");
        app.contact().fillContactForm(contact, true);
        app.contact().submitNewContact();
        app.contact().checkNewContactAdded();
        app.goTo().homePage();


        Contacts after = app.db().contacts();
        ContactData addedContact = contact
                .withAllPhones(mergePhones(contact))
                .withId(after.stream().mapToInt(c->c.getId()).max().getAsInt())
                .withAllEmails(mergeEmails(contact))
                .withEmail(null)
                .withEmail2(null)
                .withEmail3(null)
                .withHomePhone(null)
                .withMobilePhone(null)
                .withWorkPhone(null);

        Contacts beforeWithAddedContact = before.withAdded(addedContact);
        assertThat("Lists of elements should be equal", after, equalTo(beforeWithAddedContact));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter(s -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter(s -> ! s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }


//    @Test
//    public void testCurrentDir(){
//        File currentDir = new File(".");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/test/resources/js.jpg");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }
}
