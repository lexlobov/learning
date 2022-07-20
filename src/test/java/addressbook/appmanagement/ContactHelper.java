package addressbook.appmanagement;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

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

    public void fillContactForm(ContactData contactData, boolean creation, String groupName) {
        typeTextIntoField((By.name("firstname")), contactData.getFirstName());
        typeTextIntoField((By.name("middlename")), contactData.getMiddleName());
        typeTextIntoField((By.name("lastname")), contactData.getLastName());
        typeTextIntoField((By.name("mobile")), contactData.getMobilePhone());
        typeTextIntoField((By.name("email")), contactData.getEmail());
        if (creation){
            List<WebElement> elements = driver.findElements(By.tagName("option"));
            if (!(elements.size()>1)){
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(groupName);
            } else {
                new Select(driver.findElement(By.name("new_group"))).selectByIndex(0);
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

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

    public boolean isThereAContact() {
        if(driver.findElements(By.xpath("//input[@type='checkbox']")).size()>1){
            return true;
        }else {
            return false;

        }
    }

    public void createContact(ContactData.Builder newContact, String groupName) {
        fillContactForm(new ContactData.Builder()
                .withFirstName("John")
                .withEmail2("asdasd@dsf.er")
                .withLastName("Smith")
                .withMobilePhone("15464654454")
                .withGroup("test1g")
                .build(), true, groupName);
        submitNewContact();
    }
}
