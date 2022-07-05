package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreateContactTest extends TestBase {

    @Test
    public void createContactTest(){
        applicationManager.goToNewContactPage();
        applicationManager.fillNewContactForm(new ContactData("Johnny", "Michael", "Hubert", "+79885221342", "johny@maik.ru"));
        applicationManager.submitNewContact();
        applicationManager.checkContactCreated();
    }

}
