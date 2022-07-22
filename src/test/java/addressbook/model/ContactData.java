package addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String homePhone;
    private String workPhone;
    private String faxPhone;
    private String email2;
    private String email3;
    private String homePage;
    private String secondaryAddress;
    private String home;
    private String notes;

    private String group;



    public static class Builder{
       private ContactData newContact;

       public Builder(){
           newContact = new ContactData();
       }

       public Builder withId(int id){
           newContact.id = id;
           return this;
       }

       public Builder withFirstName(String firstName){
           newContact.firstName = firstName;
           return this;
       }

       public Builder withMiddleName(String middleName){
           newContact.middleName = middleName;
           return this;
       }

       public Builder withLastName(String lastName){
           newContact.lastName = lastName;
           return this;
       }

       public Builder withNickname(String nickname){
           newContact.nickname = nickname;
           return this;
       }

       public Builder title(String title){
           newContact.title = title;
           return this;
       }

       public Builder withCompany(String company){
           newContact.company = company;
           return this;
       }

       public Builder withAddress(String address){
           newContact.address = address;
           return this;
       }

       public Builder withHomePhone(String homePhone){
           newContact.homePhone = homePhone;
           return this;
       }

       public Builder withMobilePhone(String mobilePhone){
           newContact.mobilePhone = mobilePhone;
           return this;
       }

       public Builder withWorkPhone(String workPhone){
           newContact.workPhone = workPhone;
           return this;
       }

       public Builder withFaxPhone(String faxPhone){
           newContact.faxPhone = faxPhone;
           return this;
       }

       public Builder withEmail(String email){
           newContact.email = email;
           return this;
       }

       public Builder withEmail2(String email2){
           newContact.email2 = email2;
           return this;
       }

       public Builder withEmail3(String email3){
           newContact.email3 = email3;
           return this;
       }

       public Builder withHomePage(String homePage){
           newContact.homePage = homePage;
           return this;
       }

       public Builder withSecondaryAddress(String secondaryAddress){
           newContact.secondaryAddress = secondaryAddress;
           return this;
       }

       public Builder withHome(String home){
           newContact.home = home;
           return this;
       }

       public Builder withNotes(String notes){
           newContact.notes = notes;
           return this;
       }

       public Builder withGroup(String group){
           newContact.group = group;
           return this;
       }

       public ContactData build(){
           return newContact;
       }


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
        return Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(email, that.email) && Objects.equals(nickname, that.nickname) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(faxPhone, that.faxPhone) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(homePage, that.homePage) && Objects.equals(secondaryAddress, that.secondaryAddress) && Objects.equals(home, that.home) && Objects.equals(notes, that.notes) && Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, mobilePhone, email, nickname, title, company, address, homePhone, workPhone, faxPhone, email2, email3, homePage, secondaryAddress, home, notes, group);
    }
}
