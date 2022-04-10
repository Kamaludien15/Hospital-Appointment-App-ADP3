package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;

public class EmployeeRepositoryImpl implements IRepository<Employee, String> {

    private HashSet<Employee> employees = new HashSet<Employee>();

    @Override
    public Employee create(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee read(String iD) {

        Employee employee = null;

        for(Employee emp: employees)
        {
            if(emp.getEmployeeId().equals(iD))
            {
                employee = emp;
                break;
            }
        }

        return employee;

    }

    @Override
    public Employee update(Employee employee) {

        for(Employee emp: employees)
        {
            if(emp.getEmployeeId().equals(employee.getEmployeeId()))
            {
                employees.remove(emp);
                employees.add(employee);
                break;
            }
        }

        return employee;

    }

    @Override
    public boolean delete(String iD) {

        boolean status = false;

        for(Employee emp: employees)
        {
            if(emp.getEmployeeId().equals(iD))
            {
                employees.remove(emp);
                status = true;
                break;
            }
        }

        return status;

    }

}
