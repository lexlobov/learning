package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class DepartmentModel {

    @Column(name = "department_name")
    private String name;
    @Id
    @Column(name = "department_id")
    private int dbId;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private int orgId;
    private final OrganizationModel organization;
    private List<EmployeeModel> employees;

    public DepartmentModel (OrganizationModel organization){
        this.organization = organization;
    }

    public List<EmployeeModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeModel> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public DepartmentModel withName(String name) {
        this.name = name;
        return this;
    }

    public OrganizationModel getOrganization() {
        return organization;
    }
}
