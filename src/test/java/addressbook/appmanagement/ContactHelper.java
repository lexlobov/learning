package addressbook.appmanagement;

import addressbook.model.ContactData;
import addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ContactHelper extends BaseHelper {
    
    private Contacts contactCache = null;

    public int groupId;

    public ContactHelper(WebDriver driver) {

        super(driver);
    }

    public void checkNewContactAdded() {
        assertEquals("Information entered into address book.\nadd next or return to home page.", driver.findElement(By.className("msgbox")).getText());
    }

    public void submitNewContact() {
        click(By.xpath("//input[@type='submit']"));
        contactCache = null;
    }

    public void uploadPhoto(String filePath){
        driver.findElement(By.name("photo")).sendKeys(filePath);
    }

    public void clickEditButtonInTable(int id){
        driver.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
        contactCache = null;
    }

    public void fillContactForm(ContactData contactData, boolean creation, String groupName) {
        typeTextIntoField((By.name("firstname")), contactData.getFirstName());
        typeTextIntoField((By.name("lastname")), contactData.getLastName());
        typeTextIntoField((By.name("mobile")), contactData.getMobilePhone());
        typeTextIntoField((By.name("work")), contactData.getWorkPhone());
        typeTextIntoField((By.name("home")), contactData.getHomePhone());
        typeTextIntoField((By.name("email")), contactData.getEmail());
        typeTextIntoField((By.name("email2")), contactData.getEmail2());
        typeTextIntoField((By.name("email3")), contactData.getEmail3());
        typeTextIntoField((By.name("address")), contactData.getAddress());

        if (creation){
            List<WebElement> elements = driver.findElements(By.xpath("//select[@name='new_group']/option"));

            if (!(elements.size()>1)){

            } else {
                String  groupId = elements.stream().filter(e->e.getText().equals(groupName)).findFirst().get().getAttribute("value");
                setGroupId(Integer.parseInt(groupId));
                new Select(driver.findElement(By.name("new_group"))).selectByValue(groupId);
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }

    }

    public void clickUpdateButton(){
        click(By.name("update"));
        contactCache = null;
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

    public void create(ContactData newContact, String groupname) {
        fillContactForm(newContact, true, groupname);
        submitNewContact();
        contactCache = null;
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        
        for (WebElement element : elements){

            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));
            List<WebElement> rowValues = element.findElements(By.tagName("td"));

            String lastName = rowValues.get(1).getText();
            String firstName = rowValues.get(2).getText();
            String address = rowValues.get(3).getText();
            String allEmails = rowValues.get(4).getText();
            String allPhones = rowValues.get(5).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withAddress(address)
                    .withAllEmails(allEmails)
                    .withAllPhones(allPhones));
        }
        return contacts;
    }

    public int count(){
        return driver.findElements(By.name("entry")).size();
    }

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = driver.findElements(By.name("entry"));

        for (WebElement element : elements) {

            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));
            List<WebElement> rowValues = element.findElements(By.tagName("td"));

            String lastName = rowValues.get(1).getText();
            String firstName = rowValues.get(2).getText();
            String address = rowValues.get(3).getText();
            String allEmails = rowValues.get(4).getText();
            String allPhones = rowValues.get(5).getText();

            contactCache.add(new ContactData()
                    .withId(id)
                    .withFirstName(firstName)
                    .withLastName(lastName)
                    .withAddress(address)
                    .withAllEmails(allEmails)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);

    }

    public void clickCheckboxInList(int index){
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void delete(int id) {
        driver.findElement(By.cssSelector("input[id='" + id + "']")).click();
        contactCache = null;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        clickEditButtonInTable(contact.getId());
        String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = driver.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = driver.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = driver.findElement(By.name("work")).getAttribute("value");
        String email = driver.findElement(By.name("email")).getAttribute("value");
        String email2 = driver.findElement(By.name("email2")).getAttribute("value");
        String email3 = driver.findElement(By.name("email3")).getAttribute("value");
        driver.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withFirstName(firstName)
                .withLastName(lastName)
                .withHomePhone(homePhone)
                .withMobilePhone(mobilePhone)
                .withWorkPhone(workPhone)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3);
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
