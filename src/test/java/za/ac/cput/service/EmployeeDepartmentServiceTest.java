package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeDepartmentServiceTest {

    private Employee employee;
    private Department department;
    private EmployeeDepartment employeeDepartment;

    @Autowired
    private EmployeeDepartmentService service;
    @Autowired private EmployeeService employeeService;
    @Autowired private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee("Sara", "Griffin", "1991-02-03", "password");
        this.department = DepartmentFactory.createDepartment("IT", "45","10");
        this.employeeDepartment = EmployeeDepartmentFactory.createEmployeeDepartment(this.employee, this.department);
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.employeeDepartment);
    }

    @Test
    void save() {
        this.employeeService.save(this.employee);
        this.departmentService.save(this.department);
        EmployeeDepartment saved = this.service.save(this.employeeDepartment);
        System.out.println(saved);
        assertNotNull(saved);
        assertNotSame(this.employeeDepartment.getEmployeeDepartmentId(), saved.getEmployeeDepartmentId());
    }

    @Test
    void read() {
        this.employeeService.save(this.employee);
        this.departmentService.save(this.department);
        EmployeeDepartment saved = this.service.save(this.employeeDepartment);
        Optional<EmployeeDepartment> read = this.service.read(saved.getEmployeeDepartmentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getEmployeeDepartmentId(), read.get().getEmployeeDepartmentId())
        );
    }

    @Test
    void delete() {
        this.employeeService.save(this.employee);
        this.departmentService.save(this.department);
        EmployeeDepartment saved = this.service.save(this.employeeDepartment);
        this.service.delete(saved);
        List<EmployeeDepartment> employeeDepartmentList = this.service.getAll();
        assertEquals(0,employeeDepartmentList.size());
    }

    @Test
    void getAll() {
        this.employeeService.save(this.employee);
        this.departmentService.save(this.department);
        this.service.save(this.employeeDepartment);
        List<EmployeeDepartment> employeeDepartmentList = this.service.getAll();
        assertEquals(1,employeeDepartmentList.size());
    }

}
