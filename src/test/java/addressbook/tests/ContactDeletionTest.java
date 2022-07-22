package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase{

    private final String groupName = "test";

    @Test
    public void deleteContactTest(){
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().goToNewContactPage();
            app.getContactHelper().createContact(new ContactData.Builder()
                    .withFirstName("Andreas")
                    .withLastName("Corvus")
                    .withEmail("andreas@maik.ru")
                    .withGroup("test"), groupName);
            app.getContactHelper().click(By.xpath("//a[text()='home page']"));
        }
        List<ContactData> before =  app.getContactHelper().getContactList();
        app.getContactHelper().clickCheckboxInList(before.size()-1);
        app.getContactHelper().click(By.xpath("//input[@value='Delete']"));
        app.getContactHelper().checkAlertPresent();
        app.getContactHelper().checkMessageCorrect();
        app.getNavigationHelper().goToHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
