package controller;

import com.google.gson.Gson;
import model.DepartmentModel;
import model.OrganizationModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrganizationController {

    Gson gson;

    public void createNewOrg(int registrationNumber, String name, String mission){
        OrganizationModel org = new OrganizationModel()
                .withRegistrationNumber(registrationNumber)
                .withName(name)
                .withMission(mission);
        File file = new File("src/test/java/resources/orgs.json");
        String oldFileJson = file.toString();
        String json = gson.toJson(file);
        OrganizationModel[] oldList = new Gson().fromJson(json, OrganizationModel[].class);
        List<OrganizationModel> newList = List.of(oldList);
        newList.add(org);
        String stringList = newList.toString();
        String newJson = gson.toJson(stringList);
        file.

    }

    public List<OrganizationModel> getListOfOrgs(){
        return;
    }

    public List<DepartmentModel> getListOfDepartments(OrganizationModel organization){
        return;
    }

    public void createNewDepartment(OrganizationModel organization){

    }
}
