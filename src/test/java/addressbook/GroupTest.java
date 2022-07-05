package addressbook;

import org.testng.annotations.Test;

public class GroupTest extends TestBase{

    @Test
    public void groupTest(){
        applicationManager.app.goToGroupPage();
        applicationManager.app.createNewGroup();
        applicationManager.app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        applicationManager.app.submitNewGroup();
    }

}
