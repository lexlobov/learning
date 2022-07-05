package addressbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreateContactTest extends TestBase {

    @Test
    public void createContactTest(){
        goToNewContactPage();
        fillNewContactForm(new ContactData("Johnny", "Michael", "Hubert", "+79885221342", "johny@maik.ru"));
        submitNewContact();
    }

}
