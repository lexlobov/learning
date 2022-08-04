package addressbook.appmanagement;

import addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
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

    public void clickEditButtonInTable(int index){
        driver.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation, String groupName) {
        typeTextIntoField((By.name("firstname")), contactData.getFirstName());
        typeTextIntoField((By.name("middlename")), contactData.getMiddleName());
        typeTextIntoField((By.name("lastname")), contactData.getLastName());
        typeTextIntoField((By.name("mobile")), contactData.getMobilePhone());
        typeTextIntoField((By.name("email")), contactData.getEmail());
        typeTextIntoField((By.name("address")), contactData.getAddress());
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

    public void create(ContactData.Builder newContact, String groupName) {
        fillContactForm(new ContactData.Builder()
                .withFirstName("John")
                .withEmail2("asdasd@dsf.er")
                .withLastName("Smith")
                .withMobilePhone("15464654454")
                .withGroup("test1g")
                .build(), true, groupName);
        submitNewContact();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));

            String lastName = element.findElements(By.tagName("td")).get(1).getText();

            String firstName = element.findElements(By.tagName("td")).get(2).getText();

            String address = element.findElements(By.tagName("td")).get(3).getText();
            String email = element.findElements(By.tagName("td")).get(4).getText();
            String phoneNumber = element.findElements(By.tagName("td")).get(5).getText();
            contacts.add(new ContactData.Builder()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withAddress(address)
                    .withEmail(email)
                    .withMobilePhone(phoneNumber)
                    .build());
        }
        return contacts;
    }

    public void clickCheckboxInList(int index){
        driver.findElements(By.name("selected[]")).get(index).click();
    }
}
