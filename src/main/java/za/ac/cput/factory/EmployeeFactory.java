package za.ac.cput.factory;

/*
 Employee.java
 Entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.Employee;

public class EmployeeFactory {

    public Employee getEmployee(int empId, String firstName, String lastName, String dateOfBirth)
    {
        return new Employee.EmployeeBuilder()
                .buildId(empId)
                .buildName(firstName)
                .buildLastName(lastName)
                .buildDateOfBirth(dateOfBirth)
                .getEmployee();

    }//end of getEmployee method

}//end of EmployeeFactory class
