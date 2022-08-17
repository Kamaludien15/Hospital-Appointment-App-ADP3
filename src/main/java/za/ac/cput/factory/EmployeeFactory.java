package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    private EmployeeFactory(){}

    public static Employee createEmployee(String firstName, String lastName, String dateOfBirth)
    {
        if(Helper.isEmptyOrNull(firstName) || Helper.isEmptyOrNull(lastName) || Helper.isEmptyOrNull(dateOfBirth))
            return null;

        String empId = Helper.generateID();

        return new Employee.EmployeeBuilder()
                .buildId(empId)
                .buildName(firstName)
                .buildLastName(lastName)
                .buildDateOfBirth(dateOfBirth)
                .getEmployee();

    }//end of getEmployee method

}//end of EmployeeFactory class
