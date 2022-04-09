package za.ac.cput.factory;

/*
 Employee.java
 Entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.EmployeeDepartment;

public class EmployeeDepartmentFactory {

    public EmployeeDepartment getEmployeeDepartment(int departmentId, int employeeId)
    {
        return new EmployeeDepartment.EmployeeDepartmentBuilder()
                .buildId(departmentId)
                .buildEmployeeId(employeeId)
                .getEmployeeDepartment();
    }//end of getEmployeeDepartment method

}
