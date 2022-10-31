package model;

import jakarta.persistence.*;

@Entity()
@Table(name = "employees")
public class EmployeeModel {

    @Column(name = "personal_id")
    private int personalId;
    @Id
    @Column(name = "user_id")
    private int dbId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastname;

    @Column(name = "age")
    private int age;
    @Column(name = "position")
    private String position;
    private OrganizationModel organization;
    private DepartmentModel department;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private int departmentId;

    public EmployeeModel(){
    }


    public EmployeeModel withPersonalId(int personalId) {
        this.personalId = personalId;
        return this;
    }

    public EmployeeModel withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeModel withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public EmployeeModel withAge(int age) {
        this.age = age;
        return this;
    }

    public EmployeeModel withPosition(String position) {
        this.position = position;
        return this;
    }

    public EmployeeModel withOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    public EmployeeModel withDepartment(DepartmentModel department) {
        this.department = department;
        return this;
    }

    public int getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }

    public DepartmentModel getDepartment() {
        return department;
    }
}
