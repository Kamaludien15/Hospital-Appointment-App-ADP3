package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.EmployeeDepartment;
import za.ac.cput.factory.EmployeeDepartmentFactory;
import za.ac.cput.repository.impl.EmployeeDepartmentRepoImp;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentRepoImpTest {

    private EmployeeDepartment employeeDepartment;
    private EmployeeDepartment employeeDepartment2;
    private EmployeeDepartmentRepoImp employeeDepartmentRepoImp;

    @BeforeEach
    public void setUp() {
        employeeDepartmentRepoImp = EmployeeDepartmentRepoImp.getInstance();
        employeeDepartment  = EmployeeDepartmentFactory.getEmployeeDepartment("2", "4");
        employeeDepartment2 = EmployeeDepartmentFactory.getEmployeeDepartment("2", "5");
        employeeDepartmentRepoImp.create(employeeDepartment);
    }


    @Test
    void testCreate() {
        assertNotNull(employeeDepartmentRepoImp.create(employeeDepartment));
    }

    @Test
    void testRead() {
        assertNotNull(employeeDepartmentRepoImp.read("4"));
    }

    @Test
    void testUpdate() {
        assertNotNull(employeeDepartmentRepoImp.update(employeeDepartment2));
    }


    @Test
    void testGetAll()
    {
        assertNotNull(employeeDepartmentRepoImp.getAll());
    }

    @Test
    void testDelete() {
        assertTrue(employeeDepartmentRepoImp.delete("4"));
    }

}