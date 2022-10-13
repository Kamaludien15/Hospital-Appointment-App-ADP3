package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class IEmployeeDepartmentRepositoryTest {


    @Autowired
    private IEmployeeDepartmentRepository employeeDepartmentRepository;
    @Autowired private IEmployeeRepository employeeRepository;
    @Autowired private IDepartmentRepository departmentRepository;
    private Employee employee;
    private Department department;
    private EmployeeDepartment employeeDepartment;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee("Michael", "Cole", "1978-03-20");
        this.department = DepartmentFactory.createDepartment("Finance", "20","09");
        this.employeeDepartment = EmployeeDepartmentFactory.createEmployeeDepartment(employee,department);
    }

    @AfterEach
    void tearDown(){
        this.employeeDepartmentRepository.delete(this.employeeDepartment);
        this.employeeRepository.delete(this.employee);
        this.departmentRepository.delete(this.department);
    }

    @Test
    void save() {
        Employee saveEmployee = this.employeeRepository.save(this.employee);
        Department savedDepartment = this.departmentRepository.save(this.department);
        EmployeeDepartment saved = this.employeeDepartmentRepository.save(this.employeeDepartment);

        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employeeDepartment.getDepartment().getDepartmentId(), saved.getDepartment().getDepartmentId());
    }

    @Test
    void read() {
        Department savedDepartment = this.departmentRepository.save(this.department);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        EmployeeDepartment saved = this.employeeDepartmentRepository.save(this.employeeDepartment);

        Optional<EmployeeDepartment> read = this.employeeDepartmentRepository.findById(this.employeeDepartment.getEmployeeDepartmentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getEmployeeDepartmentId(), read.get().getEmployeeDepartmentId())
        );
    }

    @Test
    void delete() {
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        Department savedDepartment = this.departmentRepository.save(this.department);
        EmployeeDepartment saved = this.employeeDepartmentRepository.save(this.employeeDepartment);

        this.employeeDepartmentRepository.delete(saved);
        List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentRepository.findAll();
        assertEquals(0,employeeDepartmentList.size());
    }

    @Test
    void getAll() {
        Department savedDepartment = this.departmentRepository.save(this.department);
        Employee savedEmployee = this.employeeRepository.save(this.employee);
        this.employeeDepartmentRepository.save(this.employeeDepartment);

        List<EmployeeDepartment> employeeDepartmentList = this.employeeDepartmentRepository.findAll();
        assertEquals(1,employeeDepartmentList.size());
    }

}
