package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EmployeeDepartment;
import za.ac.cput.factory.EmployeeDepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDepartmentRepoImpTest {

    private EmployeeDepartment employeeDepartment;
    private EmployeeDepartment employeeDepartment2;
    private EmployeeDepartmentRepoImp employeeDepartmentRepoImp;

    @BeforeEach
    public void setUp() {
        employeeDepartmentRepoImp = new EmployeeDepartmentRepoImp();
        employeeDepartment  = EmployeeDepartmentFactory.getEmployeeDepartment("2", "4");
        employeeDepartment2 = EmployeeDepartmentFactory.getEmployeeDepartment("2", "5");
    }


    @Test
    void testCreate() {
        assertNotNull(employeeDepartmentRepoImp.create(employeeDepartment));
    }

    @Test
    void testRead() {
        employeeDepartmentRepoImp.create(employeeDepartment);
        assertNotNull(employeeDepartmentRepoImp.read("4"));
    }

    @Test
    void testUpdate() {
        employeeDepartmentRepoImp.create(employeeDepartment);
        assertNotNull(employeeDepartmentRepoImp.update(employeeDepartment2));
    }

    @Test
    void testDelete() {
        employeeDepartmentRepoImp.create(employeeDepartment);
        assertTrue(employeeDepartmentRepoImp.delete("4"));
    }
}