package za.ac.cput.factory;

/*
 Employee.java
 Entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.Department;

public class DepartmentFactory {

    public Department getDepartment(int departmentId, String departmentName, int departmentSize, int departmentFloor)
    {
        return new Department.DepartmentBuilder()
                .buildId(departmentId)
                .buildDepartmentName(departmentName)
                .buildDepartmentSize(departmentSize)
                .buildDepartmentFloor(departmentFloor)
                .getDepartment();
    }//end of getDepartment method

}//end of DepartmentFactory class
