package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orgs")
public class OrganizationModel {

    @Column(name = "registration_number")
    private int registrationNumber;
    @Id
    @Column(name = "org_id")
    @OneToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    private int dbId;
    @Column(name = "name")
    private String name;
    @Column(name = "mission")
    private String mission;
    @Transient
    private List<EmployeeModel> employees;
    @Transient
    private List<DepartmentModel> departments;


    public OrganizationModel withRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    public OrganizationModel withName(String name) {
        this.name = name;
        return this;
    }

    public OrganizationModel withMission(String mission) {
        this.mission = mission;
        return this;
    }

    public OrganizationModel withEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
        return this;
    }

    public OrganizationModel withDepartments(List<DepartmentModel> departments) {
        this.departments = departments;
        return this;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getMission() {
        return mission;
    }

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public List<DepartmentModel> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        return "OrganizationModel{" +
                "registrationNumber=" + registrationNumber +
                ", name='" + name + '\'' +
                ", mission='" + mission + '\'' +
                ", employees=" + employees +
                ", departments=" + departments +
                '}';
    }
}
