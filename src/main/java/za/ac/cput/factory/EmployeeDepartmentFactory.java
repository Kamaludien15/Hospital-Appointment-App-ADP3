package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.domain.Department;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.util.Helper;

public class EmployeeDepartmentFactory {

    private EmployeeDepartmentFactory(){}

    public static EmployeeDepartment createEmployeeDepartment(Employee employee, Department department)
    {
        String employeeIdDepartmentId = Helper.generateID();

        return new EmployeeDepartment.EmployeeDepartmentBuilder()
                .setEmployeeDepartmentId(employeeIdDepartmentId)
                .setEmployee(employee)
                .setDepartment(department)
                .build();
    }//end of getEmployeeDepartment method

}
