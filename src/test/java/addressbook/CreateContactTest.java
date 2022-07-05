package addressbook;

import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

    @Test
    public void createContactTest(){
        goToNewContactPage();
        fillNewContactForm(new ContactData("Johnny", "Michael", "Hubert", "+79885221342", "johny@maik.ru"));
        submitNewContact();
        checkNewContactAdded();
    }

}
