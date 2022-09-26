package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTestWithDb extends  TestBase {


    @DataProvider
    public Iterator<Object[]> validGroupsJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.json"));
        String json = "";
        String line = reader.readLine();
        while (line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = (List<GroupData>) gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
        return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validGroupsXml() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {GroupData.class}); // Без этой строки ничего не работает. Решение https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        xStream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
        return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @DataProvider
    public Iterator<Object[]> validGroupsCsv() throws IOException{
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();

    }

    @Test(dataProvider = "validGroupsJson")
    public void groupTest(GroupData group){
        app.goTo().groupPage();
        Groups before = app.db().groups();
        app.group().create(group);
        app.group().returnToGroupPage();
        Groups after = app.db().groups();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(
                group.withId(
                        after.stream().mapToInt(
                                g->g.getId()).max().getAsInt()))));
    }

    @Test
    public void groupCreationNegativeTest(){
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupData group = new GroupData().withName("test2\'");
        app.group().create(group);
        app.group().returnToGroupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before));
    }
}
