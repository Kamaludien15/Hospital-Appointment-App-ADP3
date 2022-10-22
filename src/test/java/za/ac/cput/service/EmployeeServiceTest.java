package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeServiceTest {

    private Employee employee;

    @Autowired
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee("Peter", "Splinter", "2020-20-03");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.employee);
    }

    @Test
    void save() {
        Employee saved = this.service.save(this.employee);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.employee.getEmployeeId(), saved.getEmployeeId());
    }

    @Test
    void read() {
        Employee saved = this.service.save(this.employee);
        Optional<Employee> read = this.service.read(employee.getEmployeeId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getEmployeeId(), read.get().getEmployeeId())
        );
    }

    @Test
    void delete() {
        Employee saved = this.service.save(this.employee);
        this.service.delete(saved);
        List<Employee> employees = this.service.getAll();
        assertEquals(1,employees.size());
    }

    @Test
    void getAll() {
        this.service.save(this.employee);
        List<Employee> employees = this.service.getAll();
        assertEquals(2,employees.size());
    }

}
