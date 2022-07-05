package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupTest extends TestBase {

    @Test
    public void groupTest(){
        app.goToGroupPage();
        app.createNewGroup();
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitNewGroup();
    }

}
