package model;

import java.util.List;

public class DepartmentModel {

    private String name;
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
