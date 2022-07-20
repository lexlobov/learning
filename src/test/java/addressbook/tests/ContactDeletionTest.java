package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
        app.getContactHelper().click(By.xpath("//input[@type='checkbox']"));
        app.getContactHelper().click(By.xpath("//input[@value='Delete']"));
        app.getContactHelper().checkAlertPresent();
        app.getContactHelper().checkMessageCorrect();
    }
}
