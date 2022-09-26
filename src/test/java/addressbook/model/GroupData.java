package addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

    @XStreamOmitField
    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private  String groupName;
    @Expose
    @Column(name = "group_header")
    private  String groupHeader;
    @Expose
    @Column(name = "group_footer")
    private  String groupFooter;
    @ManyToMany(mappedBy = "groups")
    private Set<ContactData> contacts = new HashSet<>();


    public GroupData() {
    }

    public Contacts getContacts() {
        return new Contacts(contacts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id && Objects.equals(groupName, groupData.groupName) && Objects.equals(groupHeader, groupData.groupHeader) && Objects.equals(groupFooter, groupData.groupFooter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, groupHeader, groupFooter);
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupHeader='" + groupHeader + '\'' +
                ", groupFooter='" + groupFooter + '\'' +
                '}';
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String groupHeader) {
        this.groupHeader = groupHeader;
        return this;
    }

    public GroupData withFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }




}
