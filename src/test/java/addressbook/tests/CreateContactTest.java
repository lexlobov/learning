package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

    @Test
    public void createContactTest(){
        app.goToNewContactPage();
        app.fillNewContactForm(new ContactData("Johnny", "Michael", "Hubert", "+79885221342", "johny@maik.ru"));
        app.submitNewContact();
        app.checkNewContactAdded();
    }

}
