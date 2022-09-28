package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import za.ac.cput.entity.Department;
import za.ac.cput.repository.IRepository;

import java.util.HashSet;

public class DepartmentRepositoryImpl implements IRepository<Department, String> {

    private HashSet<Department> departments = new HashSet<Department>();

    @Override
    public Department create(Department department) {
        departments.add(department);
        return department;
    }

    @Override
    public Department read(String iD){

        Department department = null;

        for(Department dep: departments)
        {
            if(dep.getDepartmentId().equals(iD))
            {
                department = dep;
                break;
            }
        }

        return department;
    }

    @Override
    public Department update(Department department) {

        for(Department dep: departments)
        {
            if(dep.getDepartmentId().equals(department.getDepartmentId()))
            {
                departments.remove(dep);
                departments.add(department);
                break;
            }
        }

        return department;

    }

    @Override
    public boolean delete(String iD) {

        boolean status = false;

        for(Department dep: departments)
        {
            if(dep.getDepartmentId().equals(iD))
            {
                departments.remove(dep);
                status = true;
            }
        }

        return status;
    }

}
