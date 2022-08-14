package za.ac.cput.impl;

/*
 Employee.java
 entity for the Employee
 Author: Benelzane Kholani (218257465)
 Date: 10 April 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;
import za.ac.cput.repository.impl.DepartmentRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryImplTest {

    private Department department;
    private Department department2;
    private Department department3;
    private DepartmentRepositoryImpl departmentRepository;

    @BeforeEach
    void setUp()
    {
        department             = DepartmentFactory.getDepartment("2", "IT", "100", "7");
        department2            = DepartmentFactory.getDepartment("2", "IT", "120", "7");
        department3            = DepartmentFactory.getDepartment("5", "Finance", "105", "9");
        departmentRepository   = DepartmentRepositoryImpl.getInstance();
        departmentRepository.create(department);
        departmentRepository.create(department3);
    }

    @Test
    void testCreate() {
        assertNotNull(departmentRepository.create(department));
    }

    @Test
    void testRead() {
        assertNotNull(departmentRepository.read("2"));
    }

    @Test
    void testUpdate() {
        assertNotNull(departmentRepository.update(department2));
    }

    @Test
    void testGetAll()
    {
        assertNotNull(departmentRepository.getAll());
    }

    @Test
    void testDelete() {
        assertTrue(departmentRepository.delete("5"));
    }

}