package addressbook.appmanagement;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.testng.AssertJUnit.assertEquals;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public void checkNewContactAdded() {
        assertEquals("Information entered into address book.\nadd next or return to home page.", driver.findElement(By.className("msgbox")).getText());
    }

    public void submitNewContact() {
        click(By.xpath("//input[@type='submit']"));
    }

    public void fillNewContactForm(ContactData contactData) {
        typeTextIntoField((By.name("firstname")), contactData.getFirstName());
        typeTextIntoField((By.name("middlename")), contactData.getMiddleName());
        typeTextIntoField((By.name("lastname")), contactData.getLastName());
        typeTextIntoField((By.name("mobile")), contactData.getMobilePhone());
        typeTextIntoField((By.name("email")), contactData.getEmail());
    }

    public void clickUpdateButton(){
        click(By.name("update"));
    }

    public void checkAlertPresent(){
        assertEquals( true, clickAlert());
    }

    public void checkMessageCorrect() {
        assertEquals("Record successful deleted", driver.findElement(By.className("msgbox")).getText());
    }

    public void checkContactUpdated() {
        assertEquals("Address book updated\nreturn to home page", driver.findElement(By.className("msgbox")).getText());
    }
}
