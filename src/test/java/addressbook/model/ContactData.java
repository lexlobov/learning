package addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id;
    @Expose
    @Column(name = "firstname")
    private String firstName;
    @Expose
    @Column(name = "lastname")
    private String lastName;
    @Expose
    @Column(name = "mobile")
    private String mobilePhone;
    @Expose
    @Column(name = "email")
    private String email;
    @Expose
    @Column(name = "address")
    private String address;
    @Expose
    @Column(name = "home")
    private String homePhone;
    @Expose
    @Column(name = "work")
    private String workPhone;
    @Expose
    @Column(name = "email2")
    private String email2;
    @Expose
    @Column(name = "email3")
    private String email3;
    @Transient
    private String allPhones;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();
    @Transient
    private String allEmails;
    @Column(name = "deprecated")
    private Timestamp deprecated;



    @Expose
    @Column(name = "middlename")
    private String middleName;
    @Expose
    @Column(name = "nickname")
    private String nickName;
    @Expose
    @Column(name = "photo")
    private String photo;
    @Expose
    @Column(name = "title")
    private String title;
    @Expose
    @Column(name = "company")
    private String company;
    @Expose
    @Column(name = "fax")
    private String fax;
    @Expose
    @Column(name = "homepage")
    private String homePage;
    @Expose
    @Column(name = "bday")
    private int dateOfBirth;
    @Expose
    @Column(name = "bmonth")
    private String monthOfBirth;
    @Expose
    @Column(name = "byear")
    private String yearOfBirth;
    @Expose
    @Column(name = "aday")
    private int dayOfAnniversary;
    @Expose
    @Column(name = "amonth")
    private String monthOfAnniversary;
    @Expose
    @Column(name = "ayear")
    private String yearOfAnniversary;
    @Expose
    @Column(name = "address2")
    private String secondaryAddress;
    @Expose
    @Column(name = "phone2")
    private String secondaryAddressHome;
    @Expose
    @Column(name = "notes")
    private String notes;



    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withGroups(Groups groups){
        this.groups=groups;
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


       public ContactData withLastName(String lastName){
           this.lastName = lastName;
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

    public ContactData withAllPhones(String allPhones) {
           this.allPhones = allPhones;
           return this;
    }

    public ContactData withMonthOfBirth(String monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public ContactData withYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public ContactData withDayOfAnniversary(int dayOfAnniversary) {
        this.dayOfAnniversary = dayOfAnniversary;
        return this;
    }

    public ContactData withMonthOfAnniversary(String monthOfAnniversary) {
        this.monthOfAnniversary = monthOfAnniversary;
        return this;
    }

    public ContactData withYearOfAnniversary(String yearOfAnniversary) {
        this.yearOfAnniversary = yearOfAnniversary;
        return this;
    }

    public ContactData withSecondaryAddress(String secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
        return this;
    }

    public ContactData withSecondaryAddressHome(String seocndaryAddressHome) {
        this.secondaryAddressHome = seocndaryAddressHome;
        return this;
    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ContactData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public ContactData withNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withHomePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public ContactData withDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }




    public String getAllPhones() {
        return allPhones;
    }
    public String getAllEmails() {
        return allEmails;
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
    public String getEmail2() {
        return email2;
    }
    public String getEmail3() {
        return email3;
    }
    public String getFirstName() {
        return firstName;
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
    public int getId() {
        return id;
    }
    public Timestamp getDeprecated() {
        return deprecated;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getNickName() {
        return nickName;
    }
    public String getPhoto() {
        return photo;
    }
    public String getTitle() {
        return title;
    }
    public String getCompany() {
        return company;
    }
    public String getFax() {
        return fax;
    }
    public String getHomePage() {
        return homePage;
    }
    public String getDateOfBirth() {
        return String.valueOf(dateOfBirth);
    }
    public String getMonthOfBirth() {
        return monthOfBirth;
    }
    public String getYearOfBirth() {
        return yearOfBirth;
    }
    public String getDayOfAnniversary() {
        return String.valueOf(dayOfAnniversary);
    }
    public String getMonthOfAnniversary() {
        return monthOfAnniversary;
    }
    public String getYearOfAnniversary() {
        return yearOfAnniversary;
    }
    public String getSecondaryAddress() {
        return secondaryAddress;
    }
    public String getSecondaryAddressHome() {
        return secondaryAddressHome;
    }
    public String getNotes() {
        return notes;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", groups=" + groups +
                ", allEmails='" + allEmails + '\'' +
                ", deprecated=" + deprecated +
                ", middleName='" + middleName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", fax='" + fax + '\'' +
                ", homePage='" + homePage + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", monthOfBirth='" + monthOfBirth + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", dayOfAnniversary=" + dayOfAnniversary +
                ", monthOfAnniversary='" + monthOfAnniversary + '\'' +
                ", yearOfAnniversary='" + yearOfAnniversary + '\'' +
                ", secondaryAddress='" + secondaryAddress + '\'' +
                ", secondaryAddressHome='" + secondaryAddressHome + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && dateOfBirth == that.dateOfBirth && dayOfAnniversary == that.dayOfAnniversary && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(allPhones, that.allPhones) && Objects.equals(groups, that.groups) && Objects.equals(allEmails, that.allEmails) && Objects.equals(middleName, that.middleName) && Objects.equals(nickName, that.nickName) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(fax, that.fax) && Objects.equals(homePage, that.homePage) && Objects.equals(monthOfBirth, that.monthOfBirth) && Objects.equals(yearOfBirth, that.yearOfBirth) && Objects.equals(monthOfAnniversary, that.monthOfAnniversary) && Objects.equals(yearOfAnniversary, that.yearOfAnniversary) && Objects.equals(secondaryAddress, that.secondaryAddress) && Objects.equals(secondaryAddressHome, that.secondaryAddressHome) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobilePhone, email, address, homePhone, workPhone, email2, email3, allPhones, groups, allEmails, middleName, nickName, title, company, fax, homePage, dateOfBirth, monthOfBirth, yearOfBirth, dayOfAnniversary, monthOfAnniversary, yearOfAnniversary, secondaryAddress, secondaryAddressHome, notes);
    }
}
