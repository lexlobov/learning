package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {
//        List<Object[]> list = new ArrayList<Object[]>();
//        list.add(new Object[] {new GroupData().withName("test 1").withHeader("header 1").withFooter("footer 1")});
//        list.add(new Object[] {new GroupData().withName("test 2").withHeader("header 2").withFooter("footer 3")});
//        list.add(new Object[] {new GroupData().withName("test 3").withHeader("header 3").withFooter("footer 2")});
//        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
//            String[] split = line.split(";");
//            list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});

            xml += line;
            line = reader.readLine();
        }

        XStream xStream = new XStream();
        xStream.allowTypes(new Class[] {GroupData.class}); // Без этой строки ничего не работает. Решение https://stackoverflow.com/questions/30812293/com-thoughtworks-xstream-security-forbiddenclassexception
        xStream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
        return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

    }

    @Test(dataProvider = "validGroups")
    public void groupTest(GroupData group){
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        app.group().returnToGroupPage();
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(
                group.withId(
                        after.stream().mapToInt(
                                g->g.getId()).max().getAsInt()))));
    }

    @Test
    public void groupCreationNegativeTest(){
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2\'");
        app.group().create(group);
        app.group().returnToGroupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
