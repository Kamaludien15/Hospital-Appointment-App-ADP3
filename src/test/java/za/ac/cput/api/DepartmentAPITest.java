package za.ac.cput.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Department;
import za.ac.cput.factory.DepartmentFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartmentAPITest {

    @Autowired
    private DepartmentAPI api;
    private Department department;


    @BeforeEach
    void setUp() {
        this.department = DepartmentFactory.createDepartment("IT", "45", "13");
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.department);
    }

    @Test
    void save() {
        Department saved = this.api.save(this.department);
        assertNotNull(saved);
        assertSame(this.department.getDepartmentId(), saved.getDepartmentId());
    }

    @Test
    void read() {
        Optional<Department> saved = this.api.read(this.department.getDepartmentId());
        assertNotNull(saved);
    }

    @Test
    void getAll() {
        Department saved = this.api.save(this.department);
        assertEquals(1, this.api.getAll().size());
    }

    @Test
    void delete() {
        this.api.delete(this.department);
        assertEquals(0, this.api.getAll().size());
    }

}
