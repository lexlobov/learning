package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



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
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedGroup)));

    }



}
