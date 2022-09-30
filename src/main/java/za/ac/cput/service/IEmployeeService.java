package za.ac.cput.service;

/*
* Author: Benelzane Kholani
* Date: August 2022
* IEmployeeService.java
* */

import za.ac.cput.domain.Employee;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String> {
    public List<Employee> getAll();
}
