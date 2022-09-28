package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.EmployeeDepartment;
import za.ac.cput.repository.IRepository;
import java.util.*;

public class EmployeeDepartmentRepoImp implements IRepository<EmployeeDepartment, String> {

    private HashSet<EmployeeDepartment> empDepartment = new HashSet<EmployeeDepartment>();

    @Override
    public EmployeeDepartment create(EmployeeDepartment employeeDepartment) {

        empDepartment.add(employeeDepartment);
        return employeeDepartment;
    }

    @Override
    public EmployeeDepartment read(String employeeId) {

        EmployeeDepartment employeeDepartment = null;

        for(EmployeeDepartment empDep: empDepartment)
        {
            if(empDep.getEmployeeId().equals(employeeId))
            {
                employeeDepartment = empDep;
                break;
            }

        }

        return employeeDepartment;

    }

    @Override
    public EmployeeDepartment update(EmployeeDepartment employeeDepartment) {

        for(EmployeeDepartment empDep : empDepartment)
        {
            if(empDep.getEmployeeId().equals(employeeDepartment.getEmployeeId()))
            {
                empDepartment.remove(empDep);
                empDepartment.add(employeeDepartment);
                break;
            }
        }

        return employeeDepartment;

    }

    @Override
    public boolean delete(String employeeId) {

        boolean status = false;

        for(EmployeeDepartment empDep: empDepartment){
            if(empDep.getEmployeeId().equals(employeeId))
            {
                empDepartment.remove(empDep);
                status = true;
                break;
            }
        }

        return status;
    }

}
