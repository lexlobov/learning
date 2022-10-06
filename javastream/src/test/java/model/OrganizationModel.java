package model;

import java.util.List;

public class OrganizationModel {

    private int registrationNumber;
    private String name;
    private String mission;
    private List<EmployeeModel> employees;
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
}
