package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(! app.group().isThereAGroup()){
            app.group().create(new GroupData("test1", null, null));
        }
    }

    @Test
    public void groupDeletionTest(){
        List<GroupData> before = app.group().list();
        int index = before.size()-1;
        app.goTo().groupPage();
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }



}
