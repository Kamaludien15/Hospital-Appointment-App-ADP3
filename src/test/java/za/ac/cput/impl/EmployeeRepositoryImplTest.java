package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.impl.EmployeeRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

    private Employee employee;
    private Employee employee2;
    EmployeeRepositoryImpl employeeRepository;

    @BeforeEach
    public void setUp() {
        employee   = EmployeeFactory.getEmployee("2", "Peter", "Bale", "02-03-88");
        employee2  = EmployeeFactory.getEmployee("2", "Peter", "Kate", "02-03-88");
        employeeRepository = EmployeeRepositoryImpl.getInstance();
        employeeRepository.create(employee);
    }

    @Test
    void testCreate() {
        assertNotNull(employeeRepository.create(employee));
    }

    @Test
    void testRead() {
        assertNotNull(employeeRepository.read("2"));
    }

    @Test
    void testUpdate() {
        assertNotNull(employeeRepository.update(employee2));
    }

    @Test
    void testDelete() {
        assertTrue(employeeRepository.delete("2"));
    }

    @Test
    void testGetAll()
    {
        assertNotNull(employeeRepository.getAll());
    }

}