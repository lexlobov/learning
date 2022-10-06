package model;

public class EmployeeModel {
    
    private int personalId;
    private String firstName;
    private String lastname;
    private int age;
    private String position;
    private OrganizationModel organization;
    private DepartmentModel department;

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
