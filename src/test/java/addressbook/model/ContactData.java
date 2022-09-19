package addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;


@XStreamAlias("contact")
public class ContactData {

    @XStreamOmitField
    private int id;
    @Expose
    private String firstName;
    private String middleName;
    @Expose
    private String lastName;
    @Expose
    private String mobilePhone;
    @Expose
    private String email;
    private String nickname;
    private String title;
    private String company;
    @Expose
    private String address;
    @Expose
    private String homePhone;
    @Expose
    private String workPhone;
    private String faxPhone;
    @Expose
    private String email2;
    @Expose
    private String email3;
    private String homePage;
    private String secondaryAddress;
    private String home;
    private String notes;
    private String group;
    private String allPhones;

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    private String allEmails;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withId(int id){
           this.id = id;
           return this;
       }

       public ContactData withFirstName(String firstName){
           this.firstName = firstName;
           return this;
       }

       public ContactData withMiddleName(String middleName){
           this.middleName = middleName;
           return this;
       }

       public ContactData withLastName(String lastName){
           this.lastName = lastName;
           return this;
       }

       public ContactData withNickname(String nickname){
           this.nickname = nickname;
           return this;
       }

       public ContactData title(String title){
           this.title = title;
           return this;
       }

       public ContactData withCompany(String company){
           this.company = company;
           return this;
       }

       public ContactData withAddress(String address){
           this.address = address;
           return this;
       }

       public ContactData withHomePhone(String homePhone){
           this.homePhone = homePhone;
           return this;
       }

       public ContactData withMobilePhone(String mobilePhone){
           this.mobilePhone = mobilePhone;
           return this;
       }

       public ContactData withWorkPhone(String workPhone){
           this.workPhone = workPhone;
           return this;
       }

       public ContactData withFaxPhone(String faxPhone){
           this.faxPhone = faxPhone;
           return this;
       }

       public ContactData withEmail(String email){
           this.email = email;
           return this;
       }

       public ContactData withEmail2(String email2){
           this.email2 = email2;
           return this;
       }

       public ContactData withEmail3(String email3){
           this.email3 = email3;
           return this;
       }

       public ContactData withHomePage(String homePage){
           this.homePage = homePage;
           return this;
       }

       public ContactData withSecondaryAddress(String secondaryAddress){
           this.secondaryAddress = secondaryAddress;
           return this;
       }

       public ContactData withHome(String home){
           this.home = home;
           return this;
       }

       public ContactData withNotes(String notes){
           this.notes = notes;
           return this;
       }

       public ContactData withGroup(String group){
           this.group = group;
           return this;
       }

    public ContactData withAllPhones(String allPhones) {
           this.allPhones = allPhones;
           return this;
    }


    public String getAllPhones() {
        return allPhones;
    }
    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomePage() {
        return homePage;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getHome() {
        return home;
    }

    public String getNotes() {
        return notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", faxPhone='" + faxPhone + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", homePage='" + homePage + '\'' +
                ", secondaryAddress='" + secondaryAddress + '\'' +
                ", home='" + home + '\'' +
                ", notes='" + notes + '\'' +
                ", group='" + group + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(email, that.email) && Objects.equals(nickname, that.nickname) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(faxPhone, that.faxPhone) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(homePage, that.homePage) && Objects.equals(secondaryAddress, that.secondaryAddress) && Objects.equals(home, that.home) && Objects.equals(notes, that.notes) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, mobilePhone, email, nickname, title, company, address, homePhone, workPhone, faxPhone, email2, email3, homePage, secondaryAddress, home, notes, group);
    }


}
