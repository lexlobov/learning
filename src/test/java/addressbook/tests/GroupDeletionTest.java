package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class GroupDeletionTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(! app.group().isThereAGroup()){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void groupDeletionTest(){
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }



}
