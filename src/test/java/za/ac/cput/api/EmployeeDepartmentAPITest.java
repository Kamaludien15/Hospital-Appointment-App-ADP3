package za.ac.cput.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeDepartmentAPITest {

    @Autowired
    private EmployeeDepartmentAPI api;
    @Autowired private EmployeeAPI employeeAPI;
    @Autowired private DepartmentAPI departmentAPI;
    private Employee employee;
    private Department department;
    private EmployeeDepartment employeeDepartment;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee("Johnson","Craig","1983-03-02");
        this.department = DepartmentFactory.createDepartment("Surgery", "18", "10");
        this.employeeDepartment = EmployeeDepartmentFactory.createEmployeeDepartment(this.employee, this.department);
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.employeeDepartment);
        this.employeeAPI.delete(this.employee);
        this.departmentAPI.delete(this.department);
    }

    @Test
    void save() {
        EmployeeDepartment saved = this.api.save(this.employeeDepartment);
        assertNotNull(saved);
        assertSame(this.employeeDepartment.getEmployeeDepartmentId(), saved.getEmployeeDepartmentId());
    }

    @Test
    void read() {
        Optional<EmployeeDepartment> saved = this.api.read(this.employeeDepartment.getEmployeeDepartmentId());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.employeeDepartment);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        EmployeeDepartment saved = this.api.save(this.employeeDepartment);
        assertEquals(1, this.api.getAll().size());
    }

}
