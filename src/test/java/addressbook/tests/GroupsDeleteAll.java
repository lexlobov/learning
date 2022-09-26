package addressbook.tests;

import addressbook.model.Groups;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GroupsDeleteAll extends TestBase{

    @Test(enabled = false)
    public void deleteAllGroups(){
        app.goTo().groupPage();
        app.group().deleteAll();
        assertThat(app.group().all().size(), equalTo(0));
    }
}
