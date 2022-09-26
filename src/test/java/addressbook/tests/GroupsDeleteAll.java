package addressbook.tests;

import org.testng.annotations.Test;

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
