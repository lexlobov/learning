package addressbook.generators;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    @Parameter(names = "-c", description =
    "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {

        GroupDataGenerator generator = new GroupDataGenerator();
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
        List<GroupData> groups = generateGroups(count);
        if (format.equals("csv")){
            saveCsv(groups, new File(file));
        } else if (format.equals("xml")){
            saveXml(groups, new File(file));
        } else if (format.equals("json")){
            saveJson(groups, new File(file));
        }else {
            System.out.println("Unrecognized format, enter csv or xml");
        }


    }

    private void saveJson(List<GroupData> groups, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        //xstream.alias("group", GroupData.class);
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();

    }

    private void saveCsv(List<GroupData> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData group : groups){
            writer.write(String.format("%s;%S;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
        }
        writer.close();
    }

    private List<GroupData> generateGroups(int count) {
        List<GroupData> groups = new ArrayList<>();
        for (int i= 0; i<count; i++){
            groups.add(new GroupData()
                    .withName(String.format("tst %s", i))
                    .withHeader(String.format("Header %s", i))
                    .withFooter(String.format("Footer %s", i)));
        }
        return groups;
    }
}
