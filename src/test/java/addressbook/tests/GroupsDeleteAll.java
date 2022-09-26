package addressbook.tests;

import org.testng.annotations.Test;

public class GroupsDeleteAll extends TestBase{

    @Test(enabled = false)
    public void deleteAllGroups(){
        app.goTo().groupPage();
        app.group().deleteAll();
    }
}
