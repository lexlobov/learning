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
    @Expose
    private String lastName;
    @Expose
    private String mobilePhone;
    @Expose
    private String email;
    @Expose
    private String address;
    @Expose
    private String homePhone;
    @Expose
    private String workPhone;
    @Expose
    private String email2;
    @Expose
    private String email3;
    private String allPhones;
    private String group;
    private String allEmails;
    private File photo;



    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }


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
    public String getGroup() {
        return group;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(mobilePhone, that.mobilePhone) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(email2, that.email2) && Objects.equals(email3, that.email3) && Objects.equals(allPhones, that.allPhones) && Objects.equals(group, that.group) && Objects.equals(allEmails, that.allEmails) && Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobilePhone, email, address, homePhone, workPhone, email2, email3, allPhones, group, allEmails, photo);
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
                ", group='" + group + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", photo=" + photo +
                '}';
    }

}
