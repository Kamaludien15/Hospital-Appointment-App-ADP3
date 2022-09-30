package za.ac.cput.factory;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.domain.Department;
import za.ac.cput.util.Helper;

public class DepartmentFactory {

    private DepartmentFactory(){}

    public static Department createDepartment(String departmentName, String departmentSize, String departmentFloor)
    {
        if(Helper.isEmptyOrNull(departmentName) || Helper.isEmptyOrNull(departmentSize) || Helper.isEmptyOrNull(departmentFloor))
            return null;

        String departmentId = Helper.generateID();

        return new Department.DepartmentBuilder()
                .buildId(departmentId)
                .buildDepartmentName(departmentName)
                .buildDepartmentSize(departmentSize)
                .buildDepartmentFloor(departmentFloor)
                .getDepartment();
    }//end of getDepartment method

}//end of DepartmentFactory class
