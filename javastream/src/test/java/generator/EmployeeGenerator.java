package generator;

import com.github.javafaker.Faker;
import model.DepartmentModel;
import model.EmployeeModel;
import model.OrganizationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeGenerator {

    Faker faker = new Faker();


    public List<EmployeeModel> employeeGenerator(int count, DepartmentModel department, int personalNumber){
        List <EmployeeModel> result = new ArrayList<>();
        for (int i = 0; i<count; i++){
            EmployeeModel employee = new EmployeeModel()
                    .withFirstName(faker.name().firstName())
                    .withAge(ThreadLocalRandom.current().nextInt(18, 65))
                    .withLastname(faker.name().lastName())
                    .withPosition(faker.job().position())
                    .withDepartment(department)
                    .withOrganization(department.getOrganization());
            result.add(employee);
        }
        return result;
    }
}
