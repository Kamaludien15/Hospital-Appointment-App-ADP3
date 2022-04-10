package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

    private Employee employee;
    private Employee employee2;
    EmployeeRepositoryImpl employeeRepository;

    @BeforeEach
    public void setUp() {
        employeeRepository = new EmployeeRepositoryImpl();
        employee   = EmployeeFactory.getEmployee("2", "Peter", "Bale", "02-03-88");
        employee2  = EmployeeFactory.getEmployee("2", "Peter", "Kate", "02-03-88");
    }

    @Test
    void testCreate() {
        assertNotNull(employeeRepository.create(employee));
    }

    @Test
    void testRead() {
        employeeRepository.create(employee);
        assertNotNull(employeeRepository.read("2"));
    }

    @Test
    void testUpdate() {
        employeeRepository.create(employee);
        assertNotNull(employeeRepository.update(employee2));
    }

    @Test
    void testDelete() {
        employeeRepository.create(employee);
        assertTrue(employeeRepository.delete("2"));
    }
}