package za.ac.cput.api;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeAPITest {

    @Autowired
    private EmployeeAPI api;
    private Employee employee;


    @BeforeEach
    void setUp() {
        this.employee = EmployeeFactory.createEmployee("Jake", "Dane", "2020-04-03", "MyPassword");
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.employee);
    }

    @Test
    void save() {
        Employee saved = this.api.save(this.employee);
        assertNotNull(saved);
        assertSame(this.employee.getEmployeeId(), saved.getEmployeeId());
    }

    @Test
    void read() {
        Optional<Employee> saved = this.api.read(this.employee.getEmployeeId());
        assertNotNull(saved);
    }

    @Test
    void getAll() {
        Employee saved = this.api.save(this.employee);
        assertEquals(1, this.api.getAll().size());
    }

    @Test
    void delete() {
        this.api.delete(this.employee);
        assertEquals(0, this.api.getAll().size());
    }

}
