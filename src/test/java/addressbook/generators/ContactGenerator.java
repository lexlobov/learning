package addressbook.generators;

import addressbook.model.ContactData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactGenerator {

    @Parameter(names = "-c", description =
            "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    Faker faker = new Faker();
    private final String resourcePath = "src/test/resources/";

    File photo = new File(resourcePath + "js.jpg");

    public static void main(String[] args) throws IOException {

        ContactGenerator generator = new ContactGenerator();
        JCommander jCommander = new JCommander().newBuilder().addObject(generator).build();
        try {
            jCommander.parse(args);
        } catch (ParameterException e){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")){
            saveCsv(contacts, new File(file));
        } else if (format.equals("xml")){
            saveXml(contacts, new File(file));
        } else if (format.equals("json")){
            saveJson(contacts, new File(file));
        }else {
            System.out.println("Unrecognized format, enter csv or xml");
        }


    }

    private void saveJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        //xstream.alias("group", GroupData.class);
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();

    }

    private void saveCsv(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;\n",
                    contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getMobilePhone(), contact.getHomePhone(), contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3()));
        }
        writer.close();
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i= 0; i<count; i++){
            contacts.add(new ContactData()
                    .withFirstName(faker.name().firstName())
                    .withLastName(faker.name().lastName())
                    .withAddress(faker.address().fullAddress())
                    .withMobilePhone(String.format("+7985484225%s", i))
                    .withWorkPhone(String.format("9874555%s", i))
                    .withHomePhone(String.format("85-522-%s", i))
                    .withEmail(String.format("%s@email.com", i))
                    .withEmail2(String.format("%s@yahoo.com", i))
                    .withEmail3(String.format("%s@gmail.com", i))
                    .withMiddleName(faker.name().firstName())
                    .withNickName("Mommy")
                    .withTitle("intelligence officer")
                    .withCompany(faker.company().name())
                    .withFax(faker.phoneNumber().phoneNumber())
                    .withHomePage("www.abc.com")
                    .withDateOfBirth(12)
                    .withMonthOfBirth("January")
                    .withYearOfBirth("1995")
                    .withDayOfAnniversary(12)
                    .withMonthOfAnniversary("February")
                    .withYearOfAnniversary("1999")
                    .withSecondaryAddress(faker.address().secondaryAddress())
                    .withSecondaryAddressHome("8989")
                    .withNotes("This is a test note for test user because i dont want to generate big text with technical tools")
                    .withPhoto(photo.getAbsolutePath())
            );
        }
        return contacts;
    }
}
