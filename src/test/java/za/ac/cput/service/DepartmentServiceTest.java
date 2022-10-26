package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentServiceTest {

    private Department department;

    @Autowired
    private DepartmentService service;

    @BeforeEach
    void setUp() {
        this.department = DepartmentFactory.createDepartment("Accounting", "34", "09");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.department);
    }

    @Test
    void save() {
        Department saved = this.service.save(this.department);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.department.getDepartmentId(), saved.getDepartmentId());
    }

    @Test
    void read() {
        Department saved = this.service.save(this.department);
        Optional<Department> read = this.service.read(department.getDepartmentId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getDepartmentId(), read.get().getDepartmentId())
        );
    }

    @Test
    void getAll() {
        Department saved = this.service.save(this.department);
        List<Department> departments = this.service.getAll();
        assertEquals(1,departments.size());
    }

    @Test
    void delete() {
        this.service.delete(this.department);
        List<Department> departments = this.service.getAll();
        assertEquals(0,departments.size());
    }

}
