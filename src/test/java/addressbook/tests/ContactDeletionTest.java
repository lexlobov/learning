package addressbook.tests;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    private final String groupName = "test";

    @BeforeMethod
    private void ensurePreconditions() {
        if(app.contact().list().size() == 0){
            app.goTo().contactPage();
            app.contact().create(new ContactData()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withGroup("test"), groupName);
            app.contact().click(By.xpath("//a[text()='home page']"));
        }
    }

    @Test
    public void deleteContactTest(){
        ensurePreconditions();
        List<ContactData> before =  app.contact().list();
        int index = before.size()-1;
        app.contact().clickCheckboxInList(index);
        app.contact().click(By.xpath("//input[@value='Delete']"));
        app.contact().checkAlertPresent();
        app.contact().checkMessageCorrect();
        app.goTo().homePage();

        List<ContactData> after = app.contact().list();
        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
