package addressbook;

import org.testng.annotations.Test;

public class GroupTest extends TestBase{

    @Test
    public void groupTest(){
        goToGroupPage();
        createNewGroup();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitNewGroup();
    }

}
