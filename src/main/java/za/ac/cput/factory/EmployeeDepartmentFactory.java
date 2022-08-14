package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.domain.EmployeeDepartment;

public class EmployeeDepartmentFactory {

    private EmployeeDepartmentFactory(){}

    public static EmployeeDepartment getEmployeeDepartment(String departmentId, String employeeId)
    {
        return new EmployeeDepartment.EmployeeDepartmentBuilder()
                .buildId(departmentId)
                .buildEmployeeId(employeeId)
                .getEmployeeDepartment();
    }//end of getEmployeeDepartment method

}
