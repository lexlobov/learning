package addressbook.model;

public class ContactData {
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

   public static class Builder{
       private ContactData newContact;

       public Builder(){
           newContact = new ContactData();
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
}
