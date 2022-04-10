package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Department;
import za.ac.cput.factory.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryImplTest {

    private DepartmentRepositoryImpl departmentRepository;
    private Department department;
    private Department department2;

    @BeforeEach
    void setUp()
    {
        departmentRepository  = new DepartmentRepositoryImpl();
        department            = DepartmentFactory.getDepartment("2", "IT", "100", "7");
        department2           = DepartmentFactory.getDepartment("2", "IT", "120", "7");

    }

    @Test
    void testCreate() {
        assertNotNull(departmentRepository.create(department));
    }

    @Test
    void testRead() {
        departmentRepository.create(department);
        assertNotNull(departmentRepository.read("2"));
    }

    @Test
    void testUpdate() {
        departmentRepository.create(department);
        assertNotNull(departmentRepository.update(department2));
    }

    @Test
    void testDelete() {
        departmentRepository.create(department);
        assertTrue(departmentRepository.delete("2"));
    }
}