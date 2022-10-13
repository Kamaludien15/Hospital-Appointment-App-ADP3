package za.ac.cput.repository;

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

@SpringBootTest
public class IEmployeeRepositoryTest {

    @Autowired private IEmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp(){
        this.employee = EmployeeFactory.createEmployee(employee.getEmployeeFirstName(), employee.getEmployeeLastName(), employee.getEmployeeDateOfBirth());
    }

    @AfterEach
    void tearDown(){
        this.employeeRepository.delete(this.employee);
    }

    @Test
    void save(){
        Employee save = this.employeeRepository.save(this.employee);
        System.out.println(save);
        assertAll(()->assertNotNull(save),
                ()->assertSame(this.employee.getEmployeeId(), save.getEmployeeId()));
    }

    @Test void read(){
        Employee saved = this.employeeRepository.save(this.employee);
        Optional<Employee> read = this.employeeRepository.findById(this.employee.getEmployeeId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getEmployeeId(), read.get().getEmployeeId())
        );
    }

    @Test
    void delete(){
        Employee saved = this.employeeRepository.save(this.employee);
        this.employeeRepository.delete(saved);
        List<Employee> employeeList = this.employeeRepository.findAll();
        assertEquals(0, employeeList.size());
    }

    @Test
    void getAll(){
        this.employeeRepository.save(this.employee);
        List<Employee> employeeList = this.employeeRepository.findAll();
        assertEquals(1, employeeList.size());
    }

}
